package geektime.high_frequency.top30

/**
 * 920. 播放列表的数量
 *
 * https://leetcode-cn.com/problems/number-of-music-playlists/
 */
fun main() {
    println(numMusicPlaylists(3, 3, 1))
}

fun numMusicPlaylists(N: Int, L: Int, K: Int): Int {
    val MOD = 1e9 + 7
    // dp[i][j] 为播放列表长度为 i 包含恰好 j 首不同歌曲的数量
    val dp = Array(L + 1) { LongArray(N + 1) }
    dp[0][0] = 1
    for (i in 1..L) {
        for (j in 1..N) {
            dp[i][j] += dp[i - 1][j - 1] * (N - j + 1)
            dp[i][j] += dp[i - 1][j] * (j - K).coerceAtLeast(0)
            dp[i][j] = dp[i][j].rem(MOD).toLong()
        }
    }
    return dp[L][N].toInt()
}