package geektime.high.frequency.top30

/**
 * 8. 字符串转换整数 (atoi)
 *
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
fun main() {
    println(myAtoi("123"))
    println(myAtoi("   -42"))
    println(myAtoi("words and 987"))
    println(myAtoi("-91283472332"))
    println(myAtoi("-2147483647"))
    println(myAtoi("-2147483648"))
    println(myAtoi("+2147483649"))
    println(myAtoi("4193 with words"))
    println(myAtoi("210"))
    println(myAtoi("Int.MIN_VALUE"))
    println(myAtoi("Int.MAX_VALUE"))
    println(myAtoi("words and 987"))
}

// 状态机解法
fun myAtoi(s: String): Int {
    val automaton = Automaton()
    s.toCharArray().forEach { automaton.get(it) }
    return (automaton.sign * automaton.res).toInt()
}

class Automaton {
    var sign = 1
    var res = 0L
    var state = "start"
    private val table = mutableMapOf(
        "start" to arrayOf("start", "signed", "in_number", "end"),
        "signed" to arrayOf("end", "end", "in_number", "end"),
        "in_number" to arrayOf("end", "end", "in_number", "end"),
        "end" to arrayOf("end", "end", "end", "end")
    )

    private fun getNextState(char: Char): Int {
        return if (char == ' ') 0
        else if (char == '+' || char == '-') 1
        else if (char in '0'..'9') 2
        else 3
    }

    fun get(char: Char) {
        state = table[state]?.get(getNextState(char)).toString()
        if ("in_number" == state) {
            res = res * 10 + (char - '0')
            res = if (sign == 1) res.coerceAtMost(Int.MAX_VALUE.toLong()) else res.coerceAtMost(-(Int.MIN_VALUE).toLong())
        } else if ("signed" == state) {
            sign = if (char == '+') 1 else -1
        }
    }
}

/**
 * 这个问题其实没有考察算法的知识，模拟的是日常开发中对于原始数据的处理（例如「参数校验」等场景）
 */
fun myAtoi3(s: String): Int {

    val toCharArray = s.toCharArray()
    val size = toCharArray.size
    var index = 0

    // 去除前导空格
    while (index < size && toCharArray[index] == ' ') {
        index++
    }

    // 如果已经遍历完成，直接返回0

    if (index == size) return 0

    // 如果出现符号字符，仅第 1 个有效，并记录正负
    val firstChar = toCharArray[index]
    var sign = 1
    if (firstChar == '+') {
        index++
    } else if (firstChar == '-') {
        index++
        sign = -1
    }

    // 将后续出现的数字字符进行转换，不能使用 long 类型，这是题目说的
    var res = 0
    while (index < size) {
        val c = toCharArray[index]
        if (c > '9' || c < '0') break

        // 环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > 7)) return Integer.MAX_VALUE
        if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (c - '0') > 8)) return Integer.MIN_VALUE

        // 合法的情况下，才考虑转换，每一步都把符号位乘进去
        res = res * 10 + sign * (c - '0')
        index++
    }

    return res
}
