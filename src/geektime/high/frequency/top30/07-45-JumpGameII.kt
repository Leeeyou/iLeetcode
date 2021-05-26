package geektime.high.frequency.top30

/**
 * 45. 跳跃游戏II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
fun main() {
    println(jump(intArrayOf(2, 3, 1, 2, 4, 2, 3)))
}

// 贪心算法，通过局部最优解得到全局最优解，在这就是每次选择能跳最远的那个位置
fun jump(nums: IntArray): Int {
    var step = 0
    var end = 0 // 边界
    var maxPosition = 0 // 可跳跃的最远位置
    var index = 0
    // 不访问最后一个元素，因为边界end一定大于等于最后一个位置，否则就无法跳到最后一个位置
    while (index < nums.size - 1) {
        maxPosition = maxPosition.coerceAtLeast(index + nums[index])
        // 到达边界则更新边界值，step+1
        if (index == end) {
            end = maxPosition
            step++
        }
        index++
    }
    return step
}
