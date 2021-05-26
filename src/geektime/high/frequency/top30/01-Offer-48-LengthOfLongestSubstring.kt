package geektime.high.frequency.top30

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/submissions/
 */
fun main() {
    println(lengthOfLongestSubstring2("abcabcbb"))
    println(lengthOfLongestSubstring2(""))
    println(lengthOfLongestSubstring2("bbbbb"))
    println(lengthOfLongestSubstring2("dvdf"))
}

// 优化方法
fun lengthOfLongestSubstring2(s: String): Int {
    var maxLength = 0
    val map = mutableMapOf<Char, Int>() // 记录字符及其下标位置
    var start = 0 // 头指针
    for (end in s.indices) {
        if (map.containsKey(s[end])) {
            start = (map[s[end]]!!.plus(1)).coerceAtLeast(start)  // 当字符在滑动窗口内的时候，通过查找hashMap，直接定位start要去的位置
        }
        map[s[end]] = end // 更新s[end]在map中的下标
        maxLength = maxLength.coerceAtLeast(end - start + 1)
    }
    return maxLength
}

fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = -Int.MAX_VALUE // 定义最大长度
    var start = 0 // 定义左指针,它的滑动是人为来控制
    val listOf = mutableListOf<Char>() // 定义集合,存目前遍历过的字符
    for (end in s.indices) {
        // 如果s[end]在set集合中,则移动start指针,直到s[end]不再set集合中
        while (s[end] in listOf) {
            listOf.remove(s[start++]) // 移除s[start],并将start++
        }
        maxLength = maxLength.coerceAtLeast(end - start + 1) // 取最大长度
        listOf.add(s[end]) // 将s[end]存到set集合中
    }
    if (maxLength == -Int.MAX_VALUE) maxLength = 0
    return maxLength
}