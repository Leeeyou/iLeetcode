package difficulty.easy.tree

import geektime.high_frequency.top30.TreeNode

/**
 * 110. 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 同：【剑指 Offer 55 - II. 平衡二叉树】
 * 解答见：Offer-55-II-BalancedBinaryTree.kt
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.left?.left?.left = TreeNode(6)
    root.right?.left = null
    root.right?.right = null
    println("isBalancedTree ${isBalanced(root)}")
//    println("isBalancedTree ${isBalanced2(root)}")
}