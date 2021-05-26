package geektime.advanced.algorithm.self.training._05_recursion

import geektime.high.frequency.top30.TreeNode

/**
 * 938. 二叉搜索树的范围和
 *
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = null
    println("result is ${rangeSumBST(root, 3, 5)}")
}

var result: Int = 0
fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) return result
    if (root.`val` in low..high) {
        println(root.`val`)
        result += root.`val`
    }
    if (root.`val` > low) rangeSumBST(root.left, low, high)
    if (root.`val` < high) rangeSumBST(root.right, low, high)
    return result
}