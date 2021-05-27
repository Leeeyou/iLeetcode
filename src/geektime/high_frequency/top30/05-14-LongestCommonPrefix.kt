package geektime.high_frequency.top30

/**
 * 14. 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
fun main() {
    println(longestCommonPrefix(arrayOf("green", "red", "blue")))
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(longestCommonPrefix(arrayOf("cog", "", "car")))
    println(longestCommonPrefix(arrayOf("c", "c", "c")))
    println(longestCommonPrefix(arrayOf("c")))
    println(longestCommonPrefix(arrayOf("cab", "cab", "cabc")))
    println(longestCommonPrefix(arrayOf("ab", "a")))

}

// 二分查找
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var minLength = Int.MAX_VALUE
    strs.forEach { minLength = it.length.coerceAtMost(minLength) }
    var low = 0
    var height = minLength
    while (low < height) {
        val mid = (height - low + 1) / 2 + low
        if (isCommonPrefix(strs, mid)) { // 说明0~mid属于最长公共子串，那么将low右移扩展查找范围
            low = mid
        } else { // 否则0~mid中有字符不属于最长公共子串，那么将height左移缩小查找范围
            height = mid - 1
        }
    }
    return strs[0].substring(0, low);
}

fun isCommonPrefix(strs: Array<String>, mid: Int): Boolean {
    val res = strs[0].substring(0, mid)
    var outIndex = 1
    while (outIndex < strs.size) {
        var innerIndex = 0
        while (innerIndex < mid) {
            if (res[innerIndex] != strs[outIndex][innerIndex]) {
                return false
            }
            innerIndex++
        }
        outIndex++
    }
    return true
}

// 横向扫描
fun longestCommonPrefix2(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var outIndex = 1
    val size = strs.size
    var res: String = strs[0]
    while (outIndex < size) {
        val current = strs[outIndex]
        if (current.isEmpty()) return ""
        var innerIndex = 0
        // 遍历res与current中较短的长度即可
        while (innerIndex < res.length.coerceAtMost(current.length)) {
            if (current[innerIndex] != res[innerIndex]) break
            innerIndex++
        }
        res = res.substring(0, innerIndex)
        outIndex++
    }
    return res
}