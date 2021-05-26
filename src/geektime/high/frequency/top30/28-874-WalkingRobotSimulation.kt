package geektime.high.frequency.top30

/**
 * 874. 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 */
fun main() {
    println(robotSim(intArrayOf(4, -1, 4, -2, 4), arrayOf(intArrayOf(2, 4))))
}


fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
    val directX = intArrayOf(0, 1, 0, -1) // 北东南西
    val directY = intArrayOf(1, 0, -1, 0) // 北东南西
    var curX = 0
    var curY = 0
    var curDirect = 0
    var res = 0
    val obstacleSet = mutableSetOf<Pair<Int, Int>>()
    obstacles.forEach { obstacleSet.add(Pair(it[0], it[1])) }

    commands.forEach {
        when (it) {
            -1 -> curDirect = (curDirect + 1).rem(4) // 向右转 90 度
            -2 -> curDirect = (curDirect + 3).rem(4) // 向左转 90 度
            else -> {
                for (i in 0 until it) {
                    // 试图走出一步
                    val newX = curX + directX[curDirect]
                    val newY = curY + directY[curDirect]
                    // 判断是否遇到了障碍物，是则中断循环
                    if (obstacleSet.contains(Pair(newX, newY))) {
                        return@forEach
                    }
                    // 当前坐标不是障碍点，计算并与存储的最大欧式距离的平方做比较
                    curX = newX
                    curY = newY
                    res = res.coerceAtLeast(curX * curX + curY * curY)
                }
            }
        }
    }

    return res
}
