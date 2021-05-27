package geektime.high_frequency.top30

/**
 * 480. 滑动窗口中位数
 *
 * https://leetcode-cn.com/problems/sliding-window-median/
 */
fun main() {
    medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).forEach { print("$it , ") }
    println()
}

// 插入 + 二分查找
fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    val res = DoubleArray(nums.size + 1 - k)
    val list = mutableListOf<Int>()

    // 对前k个数字使用插入排序，并使用二分查找找到最佳插入点
    for (i in 0 until k) {
        list.add(binarySearch(list, nums[i]), nums[i])
    }
    res[0] = getMedian(list, k)

    for (end in k until nums.size) {
        // 使用二分查找找到需要删除数字的下标并删除
        list.removeAt(binarySearch(list, nums[end - k]))
        // 使用二分查找找到最佳插入点
        list.add(binarySearch(list, nums[end]), nums[end])
        res[end + 1 - k] = getMedian(list, k)
    }

    return res
}

fun getMedian(list: MutableList<Int>, k: Int) =
        (list[(k - 1) / 2].toDouble() + list[k / 2].toDouble()) / 2.0

fun binarySearch(data: List<Int>, target: Int): Int {
    var l = 0
    var r = data.size - 1
    while (l <= r) {
        val m = (r - l) / 2 + l
        val d = data[m]
        when {
            target > d -> l = m + 1
            target < d -> r = m - 1
            else -> return m
        }
    }
    return l
}