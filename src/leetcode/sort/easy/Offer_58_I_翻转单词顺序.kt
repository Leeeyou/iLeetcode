package leetcode.sort.easy

import java.util.*

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */

fun main() {
    System.out.println(reverseWords("the sky is blue"))
}

fun reverseWords2(s: String): String {
    var result = ""
    val stack = Stack<Char>()
    for (i in s.length - 1 downTo 0) {
        val c = s[i]
        if (c != ' ') {
            stack.push(c)
        }
        var r = ""
        while ((i == 0 || c == ' ') && stack.isNotEmpty()) {
            r += stack.pop()
        }
        if (r.isNotEmpty()) {
            result += "$r "
        }
    }
    return result.trim()
}

fun reverseWords(s: String): String {
    var result = ""
    var slow = s.length - 1
    var fast = slow
    while (slow >= 0) {
        while (fast >= 0 && s[fast] != ' ') fast--
        result += s.substring(fast + 1, slow + 1) + " "
        while (fast >= 0 && s[fast] == ' ') fast--
        slow = fast
    }
    return result.trim()
}