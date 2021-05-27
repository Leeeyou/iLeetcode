package difficulty.easy.tree

import geektime.high_frequency.top30.TreeNode
import java.util.*

/**
 * 617. 合并二叉树
 *
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */

// dfs
fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1
    val mergeNode = TreeNode(root1.`val` + root2.`val`)
    mergeNode.left = mergeTrees(root1.left, root2.left)
    mergeNode.right = mergeTrees(root1.right, root2.right)
    return mergeNode
}

// bfs
fun mergeTrees2(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1
    val mergeNode = TreeNode(root1.`val` + root2.`val`)
    val queue = LinkedList<TreeNode>()
    val queue1 = LinkedList<TreeNode>()
    val queue2 = LinkedList<TreeNode>()
    queue.offer(mergeNode)
    queue1.offer(root1)
    queue2.offer(root2)
    while (queue1.isNotEmpty() && queue2.isNotEmpty()) {
        val node = queue.poll()
        val node1 = queue1.poll()
        val node2 = queue2.poll()
        val left1 = node1.left
        val right1 = node1.right
        val left2 = node2.left
        val right2 = node2.right
        if (left1 != null || left2 != null) {
            if (left1 != null && left2 != null) {
                val newNode = TreeNode(left1.`val` + left2.`val`)
                node.left = newNode
                queue.offer(newNode)
                queue1.offer(left1)
                queue2.offer(left2)
            } else if (left1 != null) {
                node.left = left1
            } else if (left2 != null) {
                node.left = left2
            }
        }
        if (right1 != null || right2 != null) {
            if (right1 != null && right2 != null) {
                val newNode = TreeNode(right1.`val` + right2.`val`)
                node.right = newNode
                queue.offer(newNode)
                queue1.offer(right1)
                queue2.offer(right2)
            } else if (right1 != null) {
                node.right = right1
            } else if (right2 != null) {
                node.right = right2
            }
        }
    }
    return mergeNode
}