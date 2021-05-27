package difficulty.easy.tree

import geektime.high_frequency.top30.TreeNode
import java.util.*

/**
 * 剑指 Offer 55 - I. 二叉树的深度 LCOF
 *
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */

// dfs
fun maxDepth2(root: TreeNode?): Int {
    if (root == null) return 0
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
}

// bfs
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var result = 0
    while (queue.isNotEmpty()) {
        result++
        val size = queue.size
        (1..size).forEach { _ ->
            val poll = queue.poll()
            poll.left?.also { queue.offer(it) }
            poll.right?.also { queue.offer(it) }
        }
    }
    return result
}