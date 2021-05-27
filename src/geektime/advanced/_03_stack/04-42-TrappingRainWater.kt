package geektime.advanced._03_stack

import java.util.*

/**
 * 42. 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trap(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    println(trap(intArrayOf(7, 6, 5, 4, 3, 2, 1)))
    println(trap(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)))
    println(trap(intArrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 0, 100)))

    println("---")

    println(trap2(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap2(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trap2(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    println(trap2(intArrayOf(7, 6, 5, 4, 3, 2, 1)))
    println(trap2(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)))
    println(trap2(intArrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 0, 100)))

    println("---")

    println(trap3(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap3(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trap3(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    println(trap3(intArrayOf(7, 6, 5, 4, 3, 2, 1)))
    println(trap3(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)))
    println(trap3(intArrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 0, 100)))

    println("---")

    println(trap4(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap4(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trap4(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    println(trap4(intArrayOf(7, 6, 5, 4, 3, 2, 1)))
    println(trap4(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)))
    println(trap4(intArrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 0, 100)))
}

/**
 * 暴力解法，按列求解
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
fun trap(height: IntArray): Int {
    var result = 0

    // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
    for (i in 1 until height.size - 1) {
        var maxLeft = 0
        var maxRight = 0

        // 找出左边最高
        for (j in i - 1 downTo 0) {
            if (height[j] > maxLeft) {
                maxLeft = height[j]
            }
        }

        // 找出右边最高
        for (j in i + 1 until height.size) {
            if (height[j] > maxRight) {
                maxRight = height[j]
            }
        }

        // 找出两端较小的
        val min = maxLeft.coerceAtMost(maxRight)

        // 只有较小的一段大于当前列的高度才会有水，其他情况不会有水
        if (min > height[i]) {
            result += min - height[i]
        }
    }

    return result
}

/**
 * 动态规划
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
fun trap2(height: IntArray): Int {
    var result = 0
    val maxLeft = IntArray(height.size)
    val maxRight = IntArray(height.size)

    // 动态规划：它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了
    for (i in 1 until height.size) {
        maxLeft[i] = maxLeft[i - 1].coerceAtLeast(height[i - 1])
    }

    // 动态规划：它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了
    for (i in height.size - 2 downTo 0) {
        maxRight[i] = maxRight[i + 1].coerceAtLeast(height[i + 1])
    }

    for (i in 1 until height.size) {
        // 得到i左边最高高度和右边最高高度中较小的那个
        val min = maxLeft[i].coerceAtMost(maxRight[i])
        // 如果较小高度比height[i]高，则当前i列可以蓄水min - height[i]
        if (min > height[i]) {
            result += min - height[i]
        }
    }

    return result
}

/**
 * 双指针法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * 可以自己画图试着体会一下
 */
fun trap3(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var ans = 0
    var leftMax = 0
    var rightMax = 0
    while (left < right) {
        // 如果右侧存在更高的条形块，则积水的高度依赖于当前方向（从左到右）的高度，否则开始从相反的方向遍历（从右到左）
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left]
            } else {
                // 如果当前高度小于leftMax，则说明存在"凹槽"
                ans += leftMax - height[left]
            }
            ++left
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right]
            } else {
                // 如果当前高度小于rightMax，则说明存在"凹槽"
                ans += rightMax - height[right]
            }
            --right
        }
    }
    return ans
}

/**
 * 栈解法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * 可以自己画图试着体会一下
 */
fun trap4(height: IntArray): Int {
    var result = 0
    val stack = Stack<Int>()
    var current = 0
    while (current < height.size) {
        // 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
        while (stack.isNotEmpty() && height[current] > height[stack.peek()]) {
            val h = height[stack.peek()] // 取出要出栈的元素
            stack.pop() // 出栈
            if (stack.isEmpty()) { // 栈空就出去
                break
            }
            val distance = current - stack.peek() - 1 // 两堵墙之前的距离
            val min = height[current].coerceAtMost(height[stack.peek()])
            result += distance * (min - h)
        }
        stack.push(current) // 当前指向的墙入栈
        current++ // 指针后移
    }
    return result
}

