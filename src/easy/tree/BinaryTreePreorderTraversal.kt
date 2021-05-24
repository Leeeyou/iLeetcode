package easy.tree

import geektime.high.frequency.top30.TreeNode
import java.util.*

/**
 * 144. 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = null
    println("result is ${preorderTraversal(root)}")
    result.clear()
    println("result is ${preorderTraversal2(root)}")
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return result
    result.add(root.`val`)
    root.left?.also { preorderTraversal(it) }
    root.right?.also { preorderTraversal(it) }
    return result
}

fun preorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) return result
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        result.add(pop.`val`)
        pop.left?.also { stack.push(it) }
        pop.right?.also { stack.push(it) }
    }
    return result
}