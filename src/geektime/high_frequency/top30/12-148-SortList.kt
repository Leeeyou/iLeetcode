package geektime.high_frequency.top30

/**
 * 148. 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/
 */
fun main() {

}

// 迭代+归并：写法太复杂了，没写完，尴尬...
fun sortList(head: ListNode?): ListNode? {
    val length = getLength(head)
    val dummy = ListNode(0)
    dummy.next = head

    var step = 1
    while (step < length) {
        // 每次变换步长，pre指针和cur指针都初始化在链表头
        val pre = dummy
        val cur = dummy.next
        while (cur != null) {
            val h1 = cur
            val h2 = cur.next
        }
        step *= 2
    }
    return null
}

fun getLength(head: ListNode?): Int {
    var count = 0
    var tmp = head
    while (tmp != null) {
        tmp = tmp.next
        count++
    }
    return count
}

// 递归+归并
fun sortList2(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var slow = head
    var fast = head.next
    while (fast?.next != null) {
        slow = slow?.next // 慢指针走一步
        fast = fast.next?.next // 快指针走两步
    }

    val tmp = slow?.next
    slow?.next = null // 找到中点slow后，将链表切断

    val left = sortList(head)
    val right = sortList(tmp)

    return merge(left, right)
}

// 合并两个链表，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表
private fun merge(l: ListNode?, r: ListNode?): ListNode? {
    var left = l
    var right = r
    var h = ListNode(0)
    val res = h
    while (left != null && right != null) {
        if (left.`val` < right.`val`) {
            h.next = left
            left = left.next
        } else {
            h.next = right
            right = right.next
        }
        h = h.next!!
    }
    h.next = left ?: right

    return res.next
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}