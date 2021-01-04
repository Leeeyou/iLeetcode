package geektime.advanced.algorithm.self.training._05_recursion

import geektime.high.frequency.top30.TreeNode
import java.util.*

/**
 * 101. 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
fun main() {

}

fun isSymmetric(root: TreeNode?): Boolean {
    return isMirror(root, root)
}

/**
 * 递归
 * 时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)。
 * 空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 nn，故渐进空间复杂度为 O(n)。
 */
fun isMirror(n1: TreeNode?, n2: TreeNode?): Boolean {
    if (n1 == null && n2 == null) return true
    if (n1 == null || n2 == null) return false
    if (n1.`val` == n2.`val`) return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left)
    return false
}

/**
 * 迭代
 * 时间复杂度：O(n)。
 * 空间复杂度：这里需要用一个队列来维护节点，每个节点最多进队一次，出队一次，队列中最多不会超过 n 个点，故渐进空间复杂度为 O(n)。
 */
fun check(n1: TreeNode?, n2: TreeNode?): Boolean {
    val queue = LinkedList<TreeNode>()
    queue.offer(n1)
    queue.offer(n2)
    while (queue.isNotEmpty()) {
        val u = queue.poll()
        val v = queue.poll()
        if (u == null && v == null) continue
        if ((u == null || v == null) || (u.`val` != v.`val`)) return false

        queue.offer(u.left)
        queue.offer(v.right)

        queue.offer(u.right)
        queue.offer(v.left)
    }
    return true
}