package geektime.high_frequency.top30

import java.util.*

/**
 * 430. 扁平化多级双向链表
 *
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
fun main() {
}

// 迭代+深度优先搜索
fun flatten(root: Node?): Node? {
    if (root == null) return root
    val pseudoHead = Node(0)
    pseudoHead.prev = null
    pseudoHead.next = root
    pseudoHead.child = null

    var curr: Node
    var prev = pseudoHead

    val stack = ArrayDeque<Node>()
    stack.push(root) // 头节点压栈

    // 循环迭代 stack 中的元素，直到栈为空
    while (stack.isNotEmpty()) {
        // 弹出一个节点
        curr = stack.pop()
        // 建立 prev 和 curr 之间的双向链接
        prev.next = curr
        curr.prev = prev

        // 再顺序处理 curr.next 和 curr.child 指针所指向的节点，严格按照此顺序执行
        if (curr.next != null) {
            stack.push(curr.next!!)
        }
        if (curr.child != null) {
            stack.push(curr.child!!)
            curr.child = null // 需要删除 curr.child 指针
        }

        prev = curr
    }

    pseudoHead.next!!.prev = null
    return pseudoHead.next
}

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}