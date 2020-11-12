package geektime.high.frequency.top30

/**
 * 35. 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 */
fun main() {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 0))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 9))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var res = nums.size // 注意这里赋值为最大长度，因为下面代码是在 <=nums[mid] 中赋值的
    var low = 0
    var height = nums.size - 1
    while (low <= height) {
        val mid = (height - low).shr(2) + low
        if (target <= nums[mid]) {
            res = mid
            height = mid - 1
        } else {
            low = mid + 1
        }
    }
    return res
}