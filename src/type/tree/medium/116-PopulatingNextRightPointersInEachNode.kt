package difficulty.easy.tree

import type.tree.easy.bean.Node
import java.util.*

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */

fun connect(root: Node?): Node? {
    recur2(root)
    return root
}

// 递归法
fun recur2(root: Node?) {
    if (root == null) return
    var left = root.left
    var right = root.right
    while (left != null) {
        left.next = right
        left = left.right
        right = right?.left
    }
    recur2(root.left)
    recur2(root.right)
}

// 迭代解法，广度优先搜索
// 时间复杂度：O(n)，空间复杂度：O(1)
fun connectNext(root: Node?) {
    if (root == null) return
    var temp = root
    val queue = LinkedList<Node>()
    queue.offer(root)
    // 外层循环控制层
    while (temp?.left != null) {
        val size = queue.size
        // 内存循环遍历该层的每个节点
        for (i in 1..size) {
            val node = queue.poll()
            // 建立连接
            node.left?.also { it.next = node.right }
            node.right?.also { it.next = node.next?.left }
            // 添加子节点
            node.left?.also { queue.offer(it) }
            node.right?.also { queue.offer(it) }
        }
        // 从下一层的最左边开始遍历
        temp = temp.left
    }
}
