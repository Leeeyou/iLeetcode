package geektime.advanced.algorithm.self.training._05_recursion

import geektime.high.frequency.top30.TreeNode

/**
 * 783. 二叉搜索树节点最小距离
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
fun main() {
//    [4, 2, 6, 1, 3, null, null]
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = null
    println(minDiffInBST(root))
}

var prev: Int? = null
var min: Int = Integer.MAX_VALUE
fun minDiffInBST(root: TreeNode?): Int {
    dfs(root)
    return min
}

/**
 * 在二叉搜索树中，中序遍历会将树中节点按数值大小顺序输出。只需要遍历计算相邻数的差值，取其中最小的就可以了。
 *
 * 时间复杂度：O(N)，其中 N 为树中节点的个数。
 * 空间复杂度：O(H)，其中 H 为树的高度，其为递归调用 dfs 产生函数栈的大小。
 */
fun dfs(node: TreeNode?) {
    if (node == null) return
    dfs(node.left)
    if (prev != null) min = min.coerceAtMost(node.`val` - prev!!)
    prev = node.`val`
    dfs(node.right)
}