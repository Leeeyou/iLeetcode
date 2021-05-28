package type.sort.easy

/**
 * 922. 按奇偶排序数组 II
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
fun main() {
//    val intArrayOf = intArrayOf(1, 8)
    val intArrayOf = intArrayOf(0, 1, 2, 3)
    sortArrayByParityII2(intArrayOf)
    intArrayOf.forEach { System.out.print("$it ") }
}

fun sortArrayByParityII(nums: IntArray): IntArray {
    // 先按照奇偶排序
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

    // 再交换位置
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        if (left.rem(2) != 0 && nums[left].rem(2) == 0) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }
        left++
        right--
    }
    return nums
}

// 一次遍历，性能最优
fun sortArrayByParityII2(nums: IntArray): IntArray {
    var right = 1
    for (left in nums.indices step 2) {
        if (nums[left].rem(2) == 1) { // 偶数下标的值是奇数，就要交换
            while (nums[right].rem(2) == 1) { // 奇数下标的值是奇数，继续找下一个奇数下标
                right += 2
            }
            swap(nums, left, right)
        }
    }
    return nums
}

fun swap(nums: IntArray, left: Int, right: Int) {
    val temp = nums[left]
    nums[left] = nums[right]
    nums[right] = temp
}
