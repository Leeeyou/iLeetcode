package easy.tree

import geektime.high.frequency.top30.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */

fun isBalanced(root: TreeNode?): Boolean {
    return recur(root) != -1
}

fun recur(root: TreeNode?): Int {
    if (root == null) return 0
    val left = recur(root.left)
    if (left == -1) return -1
    val right = recur(root.right)
    if (right == -1) return -1
    return if (Math.abs(left - right) < 2) Math.max(left, right) + 1 else -1
}

fun isBalanced2(root: TreeNode?): Boolean {
    if (root == null) return true
    return abs(depth(root.left) - depth(root.right)) < 2
            && isBalanced2(root.left)
            && isBalanced2(root.right)
}

fun depth(root: TreeNode?): Int {
    return if (root == null) 0
    else max(depth(root.left), depth(root.right)) + 1
}
