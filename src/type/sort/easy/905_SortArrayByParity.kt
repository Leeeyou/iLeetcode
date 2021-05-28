package type.sort.easy

/**
 * 905. 按奇偶排序数组
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */

fun sortArrayByParity(nums: IntArray): IntArray {
    var slow = 0
    for (i in nums.indices) {
        if (nums[i].rem(2) == 0) {
            slow++
        } else {
            break
        }
    }
    for (fast in slow + 1 until nums.size) {
        if (nums[fast].rem(2) == 0) {
            val i = nums[slow]
            nums[slow] = nums[fast]
            nums[fast] = i
            slow++
        }
    }
    return nums
}