package easy.tree

import geektime.high.frequency.top30.TreeNode
import java.util.*

/**
 * 102. 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
fun main() {
    levelOrder(null)
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    val queue = LinkedList<TreeNode>()
    if (root != null) {
        queue.push(root)
    }

    while (queue.isNotEmpty()) {
        val list = mutableListOf<Int>()
        val curSize = queue.size
        (1..curSize).forEach { _ ->
            queue.poll()?.also { node ->
                list.add(node.`val`)
                node.left?.also { queue.offer(it) }
                node.right?.also { queue.offer(it) }
            }
        }

        result.add(list)
    }

    return result
}