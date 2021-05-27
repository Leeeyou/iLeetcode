package geektime.advanced._01_array

/**
 * 189. 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/
 */
fun main() {
    val nums = intArrayOf(-1, -100, 3, 99)
    rotate(nums, 2)
    nums.forEach { print("$it  ") }

    println()

    val nums2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotate(nums2, 3)
    nums2.forEach { print("$it  ") }

    println()

    val nums3 = intArrayOf(1, 2)
    rotate(nums3, 3)
    nums3.forEach { print("$it  ") }
}

// 关键点在于先最后整体逆序调整，再将0 ~ k部分逆序，最后k+1 ~ n部分逆序
fun rotate(nums: IntArray, k: Int): Unit {
    val t = k.rem(nums.size)
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, t - 1)
    reverse(nums, t, nums.size - 1)
}

fun reverse(nums: IntArray, l: Int, r: Int) {
    var left = l
    var right = r
    while (left < right) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        left++
        right--
    }
}