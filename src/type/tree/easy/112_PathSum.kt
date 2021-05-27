package difficulty.easy.tree

import geektime.high_frequency.top30.TreeNode
import java.util.*

/**
 * 112. 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.left?.left?.left = TreeNode(6)

    System.out.println(hasPathSum2(root, 4))
}

// 递归法
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) return root.`val` == targetSum
    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}

// 广度优先搜索
fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    val qNode = LinkedList<TreeNode>() // 访问路径节点
    val qValue = LinkedList<Int>() // 访问路径节点和
    qNode.offer(root)
    qValue.offer(root.`val`)
    while (qNode.isNotEmpty()) {
        val node = qNode.poll()
        val curValue = qValue.poll()
        if (node.left == null && node.right == null) {
            // 唯一终止条件
            if (curValue == targetSum) return true else continue
        }

        if (node.left != null) {
            qNode.offer(node.left)
            qValue.offer(curValue + node.left!!.`val`)
        }

        if (node.right != null) {
            qNode.offer(node.right)
            qValue.offer(curValue + node.right!!.`val`)
        }
    }
    return false
}