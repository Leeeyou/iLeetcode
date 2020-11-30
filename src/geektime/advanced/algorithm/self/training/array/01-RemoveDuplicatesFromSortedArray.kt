package geektime.advanced.algorithm.self.training.array

/**
 * 26. 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 2)))
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var i = 0
    for (j in 1 until nums.size) {
        if (nums[i] != nums[j]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}