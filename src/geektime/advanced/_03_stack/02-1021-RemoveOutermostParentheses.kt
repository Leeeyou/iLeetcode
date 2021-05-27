package geektime.advanced._03_stack

import java.util.*

/**
 * 1021. 删除最外层的括号
 *
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
fun main() {
    println(removeOuterParentheses("(()())(())"))
//    println(removeOuterParentheses("(()())(())(()(()))"))
//    println(removeOuterParentheses("()()"))
}

/**
 * 碰到 "(" 就入栈，碰到 ")" 就把栈顶的一个 "(" 消掉。
 * 如果栈为空，那么刚刚碰到的 “)” 就是最外层右括号；如果入栈前栈为空，则即将入栈的 “(” 就是最外层左括号。
 * 这其实也是一种单调栈，它的单调性在于：栈里面只存在左括号，右括号仅仅是用来消灭左括号的。
 */
fun removeOuterParentheses(S: String): String {
    var result = ""
    val stack = Stack<Char>()
    S.forEach {
        if (it == '(') {
            if (stack.isNotEmpty()) {
                result += it
            }
            stack.push(it)
        } else if (it == ')') {
            stack.pop()
            if (stack.isNotEmpty()) {
                result += it
            }
        }
    }
    return result
}