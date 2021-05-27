package geektime.advanced._05_recursion

import geektime.high_frequency.top30.TreeNode
import java.util.*

/**
 * 104. 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
fun main() {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)

    root.right!!.left = TreeNode(3)
    root.right!!.left!!.right = TreeNode(4)

    println(maxDepth(root))
    println(maxDepth2(root))
}

/**
 * 递归解法
 * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
 * 空间复杂度：O(height)，其中  height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
 */
fun maxDepth(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else {
        maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1
    }
}

/**
 * 广度优先搜索
 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
 * 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。
 */
fun maxDepth2(root: TreeNode?): Int {
    if (root == null) return 0
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var maxDepth = 0
    while (queue.isNotEmpty()) {
        var size = queue.size
        while (size > 0) {
            val poll = queue.poll()
            poll.left?.also { queue.offer(it) }
            poll.right?.also { queue.offer(it) }
            size--
        }
        maxDepth++
    }
    return maxDepth
}