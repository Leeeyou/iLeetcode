package geektime.high.frequency.top30

import java.util.*
import kotlin.collections.HashSet

/**
 * 752. 打开转盘锁
 *
 * https://leetcode-cn.com/problems/open-the-lock/
 */
fun main() {
    println(openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202"))
}

fun openLock(deadends: Array<String>, target: String): Int {
    val hashSet = HashSet<String>()
    deadends.forEach { hashSet.add(it) } // 记录需要跳过的死亡密码

    val visited = HashSet<String>() // 记录已经穷举过的密码，防止走回头路
    val queue = LinkedList<String>()

    var step = 0
    // 从起点开始启动广度优先搜索
    queue.offer("0000")
    visited.add("0000")

    while (queue.isNotEmpty()) {
        val size = queue.size
        /* 将当前队列中的所有节点向周围扩散 */
        for (i in 0 until size) {
            val cur = queue.poll()
            println("cur is $cur")
            /* 判断是否到达终点 */
            if (deadends.contains(cur)) continue
            if (cur == target) return step

            /* 将一个节点的未遍历相邻节点加入队列 */
            for (j in 0 until 4) {
                val up = plusOne(cur, j)
                if (!visited.contains(up)) {
                    queue.offer(up)
                    visited.add(up)
                }

                val down = minusOne(cur, j)
                if (!visited.contains(down)) {
                    queue.offer(down)
                    visited.add(down)
                }
            }
        }
        /* 在这里增加步数 */
        step++
    }

    // 如果穷举完都没找到目标密码，那就是找不到了
    return -1
}

// 将 s[j] 向上拨动一次
fun plusOne(s: String, j: Int): String {
    val ch = s.toCharArray()
    if (ch[j] == '9') ch[j] = '0' else ch[j] = ch[j].plus(1)
    return String(ch)
}

// 将 s[i] 向下拨动一次
fun minusOne(s: String, j: Int): String {
    val ch = s.toCharArray()
    if (ch[j] == '0') ch[j] = '9' else ch[j] = ch[j].minus(1)
    return String(ch)
}
