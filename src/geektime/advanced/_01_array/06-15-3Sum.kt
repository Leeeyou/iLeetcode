package geektime.advanced._01_array

import java.util.*

/**
 * 15. 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/
 */
fun main() {
    val threeSum = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    threeSum.forEach {
        println(it)
    }
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (nums.isEmpty()) return result
    Arrays.sort(nums)
    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue // 去重，如果i与i-1的值相同，则直接跳到下一个下标
        val target = -nums[i]
        var j = i + 1 // left pointer
        var k = nums.size - 1 // right pointer
        while (j < k) {
            when {
                nums[j] + nums[k] == target -> {
                    val list = mutableListOf<Int>()
                    list.add(nums[i])
                    list.add(nums[j++])
                    list.add(nums[k--])
                    result.add(list)
                    while (j < nums.size && nums[j] == nums[j - 1]) j++ // 优化步骤，如果j与j-1的值相同，则直接跳过
                    while (k > j && nums[k] == nums[k + 1]) k-- // 优化步骤，如果k与k+1的值相同，则直接跳过
                }
                nums[j] + nums[k] > target -> k-- // >target的情况下，调小k的值，使其和趋近target
                else -> j++ // <target的情况下，调大j的值，使其和趋近target
            }
        }
    }
    return result
}