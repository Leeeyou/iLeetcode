package geektime.advanced.algorithm.self.training.binary_search

/**
 * 174. 地下城游戏
 *
 * https://leetcode-cn.com/problems/dungeon-game/
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
    val dp = Array(row + 1) { IntArray(column + 1) { Integer.MAX_VALUE } }

    dp[row][column - 1] = 1
    dp[row - 1][column] = 1

    for (i in row - 1 downTo 0) {
        for (j in column - 1 downTo 0) {
            val min = Math.min(dp[i + 1][j], dp[i][j + 1])
            dp[i][j] = Math.max(min - dungeon[i][j], 1)
        }
    }
    return dp[0][0]
}