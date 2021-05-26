package geektime.advanced.algorithm.self.training._05_recursion

import geektime.high.frequency.top30.TreeNode

/**
 * 236. 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = TreeNode(7)
    root.right?.right?.left = TreeNode(9)
    root.right?.right?.right = TreeNode(21)
    println("result is ${lowestCommonAncestor(root, root.left?.right, root.right?.right?.right)?.`val`}")
}

/**
 * 参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 *
 * 考虑通过递归对二叉树进行后序遍历，当遇到节点 p 或 q 时返回。从底至顶回溯，当节点 p , q 在节点 root 的异侧时，节点 root 即为最近公共祖先，则向上返回 root 。
 *
 * 复杂度分析：
 * 时间复杂度 O(N) ： 其中 N 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
 * 空间复杂度 O(N) ： 最差情况下，递归深度达到 N ，系统使用 O(N) 大小的额外空间。
 */
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root == p || root == q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    if (left == null) return right
    if (right == null) return left
    return root
}