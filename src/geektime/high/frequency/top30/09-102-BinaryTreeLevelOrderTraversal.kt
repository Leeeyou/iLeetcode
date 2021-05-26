package geektime.high.frequency.top30

import java.util.*

/**
 * 102. 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(levelOrder(root))

    val root2 = TreeNode(3)
    println(levelOrder(root2))

    println(levelOrder(null))

    val root4 = TreeNode(3)
    root4.right = TreeNode(20)
    root4.right!!.right = TreeNode(7)
    root4.right!!.right!!.left = TreeNode(8)
    root4.right!!.right!!.right = TreeNode(9)
    println(levelOrder(root4))
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    root ?: return res
    queue.add(root)
    while (!queue.isEmpty()) {
        val size = queue.size // 控制本次要遍历完该层的所有node数
        val levelList = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = queue.poll()
            levelList.add(node.`val`)
            node.left?.also { queue.add(it) }
            node.right?.also { queue.add(it) }
        }
        res.add(levelList)
    }
    return res
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
