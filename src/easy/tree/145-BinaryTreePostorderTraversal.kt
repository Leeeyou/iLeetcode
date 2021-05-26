package easy.tree

import geektime.high.frequency.top30.TreeNode
import java.util.*

/**
 * 145. 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = null
    println("result is ${postorderTraversal(root)}")
    result.clear()
    println("result is ${postorderTraversal2(root)}")
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return result
    root.left?.also { postorderTraversal(it) }
    root.right?.also { postorderTraversal(it) }
    result.add(root.`val`)
    return result
}

// 迭代法
fun postorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) return result
    val stack = Stack<TreeNode>()
    var curNode = root
    stack.push(curNode)
    while (stack.isNotEmpty()) {
        val node = stack.peek()
        // node.right != curNode 这里是防止curNode为right node时重复入栈同级的left node
        if (node.left != null && node.left != curNode && node.right != curNode) {
            stack.push(node.left)
        } else if (node.right != null && node.right != curNode) {
            stack.push(node.right)
        } else {
            val pop = stack.pop()
            pop?.also { result.add(it.`val`) }
            curNode = node
        }
    }
    return result
}