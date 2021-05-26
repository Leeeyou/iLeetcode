package easy.tree

import geektime.high.frequency.top30.TreeNode
import java.util.*

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(7)

    System.out.println(levelOrder2(root))
}

fun levelOrder2(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result
    val queue = ArrayDeque<TreeNode>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val list = mutableListOf<Int>()
        val size = queue.size
        (1..size).forEach { _ ->
            val first = queue.pop()
            first.left?.also { queue.offer(it) }
            first.right?.also { queue.offer(it) }
            list.add(first.`val`)
        }
        result.add(list)
    }
    return result
}