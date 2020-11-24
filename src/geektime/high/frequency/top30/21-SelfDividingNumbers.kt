package geektime.high.frequency.top30

/**
 * 728. 自除数
 *
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 */
fun main() {
    println(selfDividingNumbers(1, 10000))
}

fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val res = mutableListOf<Int>()
    for (i in left..right) {
        if (selfDividing(i)) res.add(i)
    }
    return res
}

fun selfDividing(n: Int): Boolean {
    n.toString().forEach {
        if (it == '0' || n % (it - '0') > 0) return false
    }
    return true
}