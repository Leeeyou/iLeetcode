package geektime.advanced.algorithm.self.training._04_binary_search

/**
 * 174. 地下城游戏
 *
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * bilibili视频讲解:https://www.bilibili.com/video/BV1bZ4y1u7vq?from=search&seid=13468342775181942444
 */
fun main() {
    val dungeon = Array(3) { IntArray(3) }
    dungeon[0][0] = -2
    dungeon[0][1] = -3
    dungeon[0][2] = 3

    dungeon[1][0] = -5
    dungeon[1][1] = -10
    dungeon[1][2] = 1

    dungeon[2][0] = 10
    dungeon[2][1] = 30
    dungeon[2][2] = -5

    println(calculateMinimumHP(dungeon))
}

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    val row = dungeon.size
    val column = dungeon[0].size
    // 扩充一行和一列来辅助边界判断
    val dp = Array(row + 1) { IntArray(column + 1) { Integer.MAX_VALUE } }

    // 设置dp[row][column - 1]和dp[row - 1][column]为1，即来到dp[row][column]时最少需要有1个血量
    dp[row][column - 1] = 1
    dp[row - 1][column] = 1

    for (i in row - 1 downTo 0) {
        for (j in column - 1 downTo 0) {
            /**
             * 计算去到dungeon[i][j]时所需要的最小血量
             */
            val min = Math.min(dp[i + 1][j], dp[i][j + 1])
            /**
             *  min - dungeon[i][j] > 1，说明dungeon[i][j]比要去到下一步的最小血量还少，那么想要达到dungeon[i][j]所需要的最小血量就是min - dungeon[i][j]
             *  反之则说明dungeon[i][j]比要去到下一步的最小血量还要多，那么达到dungeon[i][j]所需要的最小血量就是1
             */
            dp[i][j] = Math.max(min - dungeon[i][j], 1)
        }
    }

    return dp[0][0]
}