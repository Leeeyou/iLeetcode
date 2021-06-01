package leetcode.search.easy

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */

fun main() {
    System.out.println(searchRightBoundary(intArrayOf(1, 3, 3, 5, 7, 7, 9, 12, 12, 20), 7))
    System.out.println(searchRightBoundary(intArrayOf(1, 3, 3, 5, 7, 7, 9, 12, 12, 20), 6))

    System.out.println(searchRightBoundary(intArrayOf(5, 7, 7, 8, 8, 10), 6) - searchRightBoundary(intArrayOf(5, 7, 7, 8, 8, 10), 5))
    System.out.println(searchRightBoundary(intArrayOf(5, 7, 7, 8, 8, 10), 8) - searchRightBoundary(intArrayOf(5, 7, 7, 8, 8, 10), 7))
    System.out.println(searchRightBoundary(intArrayOf(), 8) - searchRightBoundary(intArrayOf(), 7))
    System.out.println(searchRightBoundary(intArrayOf(8), 8) - searchRightBoundary(intArrayOf(), 7))
}

fun search2(nums: IntArray, target: Int): Int {
    val right = searchMost(nums, target)
    val left = searchLease(nums, target)
    return if (right != -1 && left != -1) {
        right - left + 1
    } else if (left != -1 || right != -1) {
        1
    } else {
        0
    }
}

// 最左相等
fun searchLease(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var result = -1
    while (left <= right) {
        val mid = left + (right - left).shr(1) // 向下取整,让middle尽量往左靠
        when {
            target > nums[mid] -> left = mid + 1
            target < nums[mid] -> right = mid - 1
            else -> {
                result = mid
                right = mid - 1
            }
        }
    }
    return result
}

// 最右相等
fun searchMost(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var result = -1
    while (left <= right) {
        val mid = left + (right - left + 1).shr(1) // 向上取整,让middle尽量往右靠
        when {
            target > nums[mid] -> left = mid + 1
            target < nums[mid] -> right = mid - 1
            else -> {
                result = mid
                left = mid + 1
            }
        }
    }
    return result
}

// 找target的右边界，注意是右边界，不是最右边相等
fun searchRightBoundary(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left + 1).shr(1) // 向上取整,让middle尽量往右靠
        when {
            target >= nums[mid] -> left = mid + 1
            target < nums[mid] -> right = mid - 1
        }
    }
    return left
}