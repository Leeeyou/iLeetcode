package leetcode.search.easy

/**
 * 704. 二分查找
 *
 * https://leetcode-cn.com/problems/binary-search/
 */

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 6, 7)
    System.out.println(searchLease(array, 4))
    System.out.println(searchMost(array, 4))

//    System.out.println(search(array, 4))
//    System.out.println(search(intArrayOf(), 4))
//    System.out.println(search(intArrayOf(3), 4))
//    System.out.println(search(intArrayOf(3), 3))
}

fun search(nums: IntArray, target: Int): Int {
    return find(nums, 0, nums.size - 1, target)
}

fun find(nums: IntArray, l: Int, r: Int, t: Int): Int {
    if (l > r) return -1
    val mid = l + (r - l).shr(1)
    return when {
        t > nums[mid] -> find(nums, mid + 1, r, t)
        t < nums[mid] -> find(nums, l, mid - 1, t)
        t == nums[mid] -> mid
        else -> -1
    }
}