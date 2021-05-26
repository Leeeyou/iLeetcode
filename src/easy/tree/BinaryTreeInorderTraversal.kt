package easy.tree

import geektime.high.frequency.top30.TreeNode
import java.util.*

/**
 * 94. 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = null
    println("result is ${inorderTraversal(root)}")
    result.clear()
    println("result is ${inorderTraversal2(root)}")
}

// 递归法
val result = mutableListOf<Int>()
fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return result
    root.left?.also { inorderTraversal(it) }
    result.add(root.`val`)
    root.right?.also { inorderTraversal(it) }
    return result
}

// 迭代法
fun inorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) return result
    val stack = Stack<TreeNode>()
    var curNode = root
    while (stack.isNotEmpty() || curNode != null) {
        while (curNode != null) {
            stack.push(curNode)
            curNode = curNode.left
        }
        val pop = stack.pop()
        pop?.also { result.add(it.`val`) }
        pop?.right?.also { curNode = it }
    }
    return result
}
