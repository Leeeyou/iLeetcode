package geektime.advanced._03_stack

import java.util.*


/**
 * 84. 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
fun main() {
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    println(largestRectangleArea(intArrayOf(1, 2, 3, 4, 5)))
    println(largestRectangleArea(intArrayOf(5, 4, 3, 2, 1)))
}

/**
 * 单调递增栈：如果新的元素比栈顶元素大，就入栈；如果新的元素较小，那就一直把栈内元素弹出来，直到栈顶比新元素小
 * 加入这样一个规则之后，栈内的元素是递增的：
 *      当元素出栈时，说明这个新元素是出栈元素向后找第一个比其小的元素
 *      当元素出栈后，说明新栈顶元素是出栈元素向前找第一个比其小的元素
 */
fun largestRectangleArea(heights: IntArray): Int {
    var size = heights.size
    if (size == 0) {
        return 0
    }

    if (size == 1) {
        return heights[0]
    }

    // 创建新的数组，在首和尾都填入0
    val newHeights = IntArray(size + 2)
    newHeights[0] = 0
    System.arraycopy(heights, 0, newHeights, 1, size)
    newHeights[size + 1] = 0
    size += 2

    val stack: Deque<Int> = ArrayDeque(size)
    stack.addLast(0) // 先放入哨兵，在循环里就不用做非空判断

    var maxArea = 0
    for (i in 1 until size) {
        // 向右找到第一个小于栈顶的元素
        while (newHeights[stack.peekLast()] > newHeights[i]) {
            val currentHeight = newHeights[stack.pollLast()]
            val currentWidth = i - stack.peekLast() - 1
            maxArea = maxArea.coerceAtLeast(currentWidth * currentHeight)
        }
        stack.addLast(i)
    }
    return maxArea
}