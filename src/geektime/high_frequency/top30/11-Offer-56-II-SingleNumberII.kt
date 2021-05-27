package geektime.high_frequency.top30

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
fun main() {
    println(singleNumberII(intArrayOf(6, 3, 3, 3)))
}

// 位运算
fun singleNumberII(nums: IntArray): Int {
    var res = 0
    if (nums.isEmpty()) return res
    for (i in 0 until 32) {
        var count = 0 // 统计该位1的出现次数情况
        val index = 1.shl(i)
        for (j in nums) {
            // 该位与操作后的结果不为0，则表示该位为1的情况出现了
            if (index.and(j) != 0) {
                count++
            }
        }
        // 该位上出现1的次数mod3后为1，表示出现一次的数字该位为1
        if (count.rem(3) != 0) {
            res = res.or(index)
        }
    }
    return res
}