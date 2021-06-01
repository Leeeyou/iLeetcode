package leetcode.sort.easy

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */

fun exchange(nums: IntArray): IntArray {
    var slow = 0
    for (i in 0..nums.size - 1) {
        if (nums[i].rem(2) == 0) {
            slow = i
            break;
        }
    }

    for (fast in slow + 1..nums.size - 1) {
        if (nums[fast].rem(2) == 1) {
            val temp = nums[slow]
            nums[slow] = nums[fast]
            nums[fast] = temp
            slow++
        }
    }

    return nums
}