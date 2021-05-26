package geektime.advanced.algorithm.self.training._05_recursion

import geektime.high.frequency.top30.TreeNode
import java.lang.StringBuilder
import java.util.*

/**
 * 257. 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = null
    root.right?.right = null
    println(binaryTreePaths(root))
}

fun binaryTreePaths(root: TreeNode?): List<String> {
//    val paths = mutableListOf<String>()
//    constructPathsDfs(root, "", paths)
//    return paths

    return constructPathsBfs(root)
}

/**
 * 深度优先搜索
 * 时间复杂度：O(N^2) 其中 N 表示节点数目。在深度优先搜索中每个节点会被访问一次且只会被访问一次，每一次会对 path 变量进行拷贝构造，时间代价为 O(N)，故时间复杂度为 O(N^2)
 * 空间复杂度：O(N^2)其中 N 表示节点数目。除答案数组外我们需要考虑递归调用的栈空间。在最坏情况下，当二叉树中每个节点只有一个孩子节点时，即整棵二叉树呈一个链状，此时递归的层数为 N，
 *  此时每一层的 path 变量的空间代价的总和 O(N^2)，空间复杂度为 O(N^2)。最好情况下，当二叉树为平衡二叉树时，它的高度为 logN，此时空间复杂度为 O((logN)2)。
 */
fun constructPathsDfs(node: TreeNode?, path: String, paths: MutableList<String>) {
    if (node != null) {
        val sb = StringBuilder(path)
        sb.append(node.`val`)
        if (node.left == null && node.right == null) { // 当前节点是叶子节点
            paths.add(sb.toString()) // 把路径加入到答案中
        } else {
            sb.append("->")  // 当前节点不是叶子节点，继续递归遍历
            constructPathsDfs(node.left, sb.toString(), paths)
            constructPathsDfs(node.right, sb.toString(), paths)
        }
    }
}

/**
 * 广度优先搜索
 * 时间复杂度：O(N^2)其中 NN 表示节点数目。分析同方法一。
 * 空间复杂度：O(N^2)其中 NN 表示节点数目。在最坏情况下，队列中会存在 NN 个节点，保存字符串的队列中每个节点的最大长度为 NN，故空间复杂度为 O(N^2)
 */
fun constructPathsBfs(node: TreeNode?): List<String> {
    val paths = mutableListOf<String>()
    if (node == null) return paths

    val nodeQueue = LinkedList<TreeNode>()
    val pathQueue = LinkedList<String>()

    nodeQueue.offer(node)
    pathQueue.offer(node.`val`.toString())

    while (nodeQueue.isNotEmpty()) {
        val n = nodeQueue.poll()
        val p = pathQueue.poll()

        if (n.left == null && n.right == null) {
            paths.add(p)
        } else {
            if (n.left != null) {
                pathQueue.offer(StringBuilder(p).append("->").append(n.left!!.`val`).toString())
                nodeQueue.offer(n.left)
            }
            if (n.right != null) {
                pathQueue.offer(StringBuilder(p).append("->").append(n.right!!.`val`).toString())
                nodeQueue.offer(n.right)
            }
        }
    }

    return paths
}