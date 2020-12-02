package geektime.advanced.algorithm.self.training.array

/**
 * 88. 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
fun main() {
    val nums1 = intArrayOf(1, 9, 10, 0, 0, 0)
    merge(nums1, 3, intArrayOf(4, 5, 6), 3)
    nums1.forEach { print("$it ") }
}

//  双指针，从后往前
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = m - 1
    var p2 = n - 1
    var p = m + n - 1

    while (p1 >= 0 && p2 >= 0) {
        nums1[p--] = if (nums1[p1] < nums2[p2]) nums2[p2--] else nums1[p1--]
    }

    System.arraycopy(nums2, 0, nums1, 0, p2 + 1)
}