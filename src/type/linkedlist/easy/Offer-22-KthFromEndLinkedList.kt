package type.linkedlist.easy

import geektime.advanced._01_array.ListNode

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)
    l1.next!!.next!!.next = ListNode(4)
    l1.next!!.next!!.next!!.next = ListNode(5)

    val kthFromEnd = getKthFromEnd(l1, 5)
    System.out.println(kthFromEnd?.`val`)
}

fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    var slow = head
    var fast = head

    var temp = 1
    while (fast?.next != null && k > 1 && temp < k) {
        fast = fast.next
        temp++
    }
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next
    }
    return slow
}