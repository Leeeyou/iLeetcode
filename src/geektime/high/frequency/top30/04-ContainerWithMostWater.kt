package geektime.high.frequency.top30

/**
 * 11. 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1, 1)))
    println(maxArea(intArrayOf(4, 3, 2, 1, 4)))
    println(maxArea(intArrayOf(1, 2, 1)))
}

fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        val currentArea = height[left].coerceAtMost(height[right]) * (right - left)
        maxArea = maxArea.coerceAtLeast(currentArea)
        if (height[left] < height[right]) left++ else right--
    }
    return maxArea
}