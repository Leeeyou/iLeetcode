package easy.array

/**
 * 283. 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 类似问题：【5.11. 字符串的左右移动】
 */

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 6, 5, 4)
    val nums2 = intArrayOf(0, 0, 0, 0, 0, 0)
    val nums3 = intArrayOf(0, 1, 0, 3, 0, 12, 0, 0, 0, 0, 11, 20, 30, 40)
    moveZeroes(nums1)
    moveZeroes(nums2)
    moveZeroes(nums3)
    nums1.forEach { System.out.print("$it ") }
    println()
    nums2.forEach { System.out.print("$it ") }
    println()
    nums3.forEach { System.out.print("$it ") }
}

fun moveZeroes(nums: IntArray): Unit {
    var slow = 0

    while (slow < nums.size) {
        if (nums[slow] == 0) {
            break
        }
        slow++
    }

    for (fast in slow + 1 until nums.size) {
        if (nums[fast] != 0) {
            nums[slow] = nums[fast]
            nums[fast] = 0
            slow++
        }
    }
}