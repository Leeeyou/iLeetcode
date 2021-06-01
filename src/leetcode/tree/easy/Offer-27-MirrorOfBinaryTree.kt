package difficulty.easy.tree

import geektime.high_frequency.top30.TreeNode
import java.util.*

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */

// 递归法
fun mirrorTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val temp = root.left
    root.left = mirrorTree(root.right)
    root.right = mirrorTree(temp)
    return root
}

// 辅助栈（或队列）
fun mirrorTree2(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        pop.left?.also { stack.push(it) }
        pop.right?.also { stack.push(it) }
        val temp = pop.left
        pop.left = pop.right
        pop.right = temp
    }
    return root
}