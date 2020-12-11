package geektime.advanced.algorithm.self.training.binary_search

/**
 * 441. 排列硬币
 *
 * https://leetcode-cn.com/problems/arranging-coins/
 */
fun main() {
    println(arrangeCoins(8))
    println(arrangeCoins(5))
    println(arrangeCoins(509876))
    println(arrangeCoins(0))
    println(arrangeCoins(100))
    println(arrangeCoins(1))
    println(arrangeCoins(2))
    println(arrangeCoins(3))
    println(arrangeCoins(4))
    println(arrangeCoins(1804289383))
}

/**
 * 二分查找解法
 */
fun arrangeCoins(n: Int): Int {
    var left = 0L
    var right = n.toLong()
    var mid: Long
    var sum: Long
    val target = right
    while (left <= right) {
        mid = left + (right - left) / 2
        // 等差数列求和公式
        sum = mid * (mid + 1) / 2
        when {
            target == sum -> return mid.toInt()
            n > sum -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return right.toInt()
}