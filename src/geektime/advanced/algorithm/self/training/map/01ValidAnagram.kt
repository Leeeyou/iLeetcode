package geektime.advanced.algorithm.self.training.map

/**
 * 242. 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/
 */
fun main() {
    println(isAnagram("abc", "cba"))
    println(isAnagram("abc", "cbad"))
    println(isAnagram("anagram", "nagaram"))
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val array = IntArray(26)
    for (i in s.indices) {
        array[s[i] - 'a']++
        array[t[i] - 'a']--
    }
    array.forEach { if (it != 0) return false }
    return true
}