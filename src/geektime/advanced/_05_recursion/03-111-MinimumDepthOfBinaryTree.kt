package geektime.advanced._05_recursion

import geektime.high_frequency.top30.TreeNode

/**
 * 111. 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.left?.left = null
    root.left?.right = null
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    println(minDepth(root))
    println(minDepth(null))

    val root2 = TreeNode(2)
    root2.left = null
    root2.right = TreeNode(3)
    root2.right?.right = TreeNode(4)
    root2.right?.right?.right = TreeNode(5)
    root2.right?.right?.right?.right = TreeNode(6)
    println(minDepth(root2))

    val root3 = TreeNode(1)
    root3.left = TreeNode(2)
    println(minDepth(root3))
}

/**
 * 深度优先搜索 DFS
 * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
 * 空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。
 * 平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
 *
 * 这道题的关键是搞清楚递归结束条件
 * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
 * 当 root 节点左右孩子都为空时，返回 1
 * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
 * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
 */
fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left == null && root.right != null) {
        return 1 + minDepth(root.right)
    }
    if (root.left != null && root.right == null) {
        return 1 + minDepth(root.left)
    }
    return 1 + minDepth(root.left).coerceAtMost(minDepth(root.right))
}