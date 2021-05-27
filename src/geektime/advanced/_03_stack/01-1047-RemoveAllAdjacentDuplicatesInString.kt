package geektime.advanced._03_stack

import java.util.*

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
fun main() {
    println(removeDuplicates("abbaca"))
    println(removeDuplicates("abaca"))
    println(removeDuplicates(""))
    println(removeDuplicates("bbaad"))
    println(removeDuplicates("bbaaddddop"))
}

fun removeDuplicates(S: String): String {
    val stack = Stack<Char>()
    S.forEach {
        if (stack.isNotEmpty() && it == stack.peek()) {
            stack.pop()
        } else {
            stack.push(it)
        }
    }
    return String(stack.toCharArray())
}