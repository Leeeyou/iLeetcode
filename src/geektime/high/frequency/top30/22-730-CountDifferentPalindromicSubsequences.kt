package geektime.high.frequency.top30

/**
 * 730. 统计不同回文子序列
 *
 * https://leetcode-cn.com/problems/count-different-palindromic-subsequences/
 *
 * bilibili视频讲解 : https://www.bilibili.com/video/BV12W41167vQ?from=search&seid=16118702513415040498
 */
fun main() {
    println(countPalindromicSubsequences("a"))
    println(countPalindromicSubsequences("ab"))
    println(countPalindromicSubsequences("bccb"))
    println(countPalindromicSubsequences("bcbcb"))
    println(countPalindromicSubsequences("bbcbcbb"))
    println(countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"))
}

fun countPalindromicSubsequences(S: String): Int {
    val KMOD = 1e9 + 7
    val n = S.length
    val dp = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        dp[i][i] = 1
    }

    // 开始动态规划
    for (len in 1..n) {
        for (i in 0 until n - len) {
            val j = i + len
            if (S[i] == S[j]) {
                dp[i][j] = dp[i + 1][j - 1] * 2
                var l = i + 1
                var r = j - 1
                // l用于寻找与S[i]相同的左端第一个下标，r用于寻找与S[i]相同的右端第一个下标
                while (l <= r && S[l] != S[i]) l++
                while (l <= r && S[r] != S[i]) r--
                when {
                    l == r -> dp[i][j] += 1 // //中间只有一个和S[i]相同的字母，就是"aaa"这种情况
                    l > r -> dp[i][j] += 2 // 中间没有和S[i]相同的字母，例如"aba"这种情况
                    else -> dp[i][j] -= dp[l + 1][r - 1] // 中间至少有两个和S[i]相同的字母，就是"aabaa"这种情况
                }
            } else {
                // 首尾字母不相同，则转化成i到j-1到结果加上i+1到j到结果减去i+1到j-1到结果
                // "abcd" = "abc" + "bcd" - "bc"
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]
            }

            dp[i][j] = ((dp[i][j] + KMOD) % KMOD).toInt()
        }
    }
    return dp[0][n - 1]
}