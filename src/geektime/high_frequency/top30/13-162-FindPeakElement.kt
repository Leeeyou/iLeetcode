package geektime.high_frequency.top30

/**
 * 162. 寻找峰值
 *
 * https://leetcode-cn.com/problems/find-peak-element/
 */
fun main() {
    println(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    println(findPeakElement(intArrayOf(1, 2, 3, 1)))
}

// 迭代二分查找
fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    var mid: Int
    while (left < right) {
        mid = (right + left) / 2
        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    // 最后left==right
    return left
}