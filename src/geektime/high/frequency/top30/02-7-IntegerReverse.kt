package geektime.high.frequency.top30

/**
 * 7. 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 */
fun main() {
    println(reverse2(123))
    println(reverse2(-123))
    println(reverse2(8901))
    println(reverse2(210))
    println(reverse2(Int.MIN_VALUE))
    println(reverse2(Int.MAX_VALUE))
}

fun reverse(x: Int): Int {
    var res = 0L
    var temp = x
    while (temp != 0) {
        res = res * 10 + temp.rem(10)
        temp = temp.div(10)
    }
    return if (res.compareTo(res.toInt()) == 0) res.toInt() else 0
}

fun reverse2(x: Int): Int {
    var res = 0
    var temp = x
    while (temp != 0) {
        // pop
        val pop = temp.rem(10)
        temp = temp.div(10)

        // push
        if (res > Int.MAX_VALUE.div(10) || res == Int.MAX_VALUE.div(10) && pop > 7) return 0 // Int.MAX_VALUE is 2147483647
        if (res < Int.MIN_VALUE.div(10) || res == Int.MIN_VALUE.div(10) && pop < -8) return 0 // Int.MIN_VALUE is -2147483648
        res = res * 10 + pop
    }
    return res
}