package leetcode.tree.medium

import leetcode.tree.easy.bean.Node
import java.util.*

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

fun connect2(root: Node?): Node? {
    recur2(root)
    return root
}

// 迭代解法，广度优先搜索
// 时间复杂度：O(n)，空间复杂度：O(1)
fun connectNext2(root: Node?) {
    if (root == null) return
    val queue = LinkedList<Node>()
    queue.offer(root)
    while (queue.isNotEmpty()) { // 外层循环控制层
        val size = queue.size
        var pre: Node? = null  // 前一个节点
        for (i in 1..size) { // 内存循环遍历该层的每个节点
            queue.poll()?.also { node ->
                pre?.also { it.next = node }
                pre = node
                // 添加子节点
                node.left?.also { left -> queue.offer(left) }
                node.right?.also { right -> queue.offer(right) }
            }
        }
    }
}
