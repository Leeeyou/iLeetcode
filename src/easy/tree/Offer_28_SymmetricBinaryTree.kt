package easy.tree

import geektime.high.frequency.top30.TreeNode

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */

fun isSymmetric(root: TreeNode?): Boolean {
    return if (root == null) true else recur(root.left, root.right)
}

fun recur(l: TreeNode?, r: TreeNode?): Boolean {
    if (l == null && r == null) return true
    if (l == null || r == null || l.`val` != r.`val`) return false
    return recur(l.left, r.right) && recur(l.right, r.left)
}
