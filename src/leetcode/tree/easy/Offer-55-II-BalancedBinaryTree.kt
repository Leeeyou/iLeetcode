package difficulty.easy.tree

import geektime.high_frequency.top30.TreeNode

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */

fun isBalanced(root: TreeNode?): Boolean {
//    return recur(root) != -1
    val depth = helper(root)
    System.out.println("tree depth is $depth")
    return res
}

// 后序遍历 + 剪枝（从底至顶）
fun recur(root: TreeNode?): Int {
    if (root == null) return 0
    val left = recur(root.left)
    if (left == -1) return -1
    val right = recur(root.right)
    if (right == -1) return -1
    return if (Math.abs(left - right) < 2) Math.max(left, right) + 1 else -1
}

// 从底至顶判断每个节点是否为平衡二叉树
var res = true
private fun helper(root: TreeNode?): Int {
    if (root == null) return 0
    val left = helper(root.left) + 1
    val right = helper(root.right) + 1
    if (Math.abs(right - left) > 1) res = false
    return Math.max(left, right)
}

// 先序遍历 + 判断深度（从顶至底）
fun isBalanced2(root: TreeNode?): Boolean {
    if (root == null) return true
    return Math.abs(depth(root.left) - depth(root.right)) < 2
            && isBalanced2(root.left)
            && isBalanced2(root.right)
}

fun depth(root: TreeNode?): Int {
    return if (root == null) 0
    else Math.max(depth(root.left), depth(root.right)) + 1
}