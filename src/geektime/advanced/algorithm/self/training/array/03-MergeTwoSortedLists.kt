package geektime.advanced.algorithm.self.training.array

/**
 * 21. 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(2)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)

    var res = mergeTwoLists2(l1, l2)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}

// 迭代法
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var pre: ListNode? = ListNode(Int.MIN_VALUE)
    val head = pre
    var list1 = l1
    var list2 = l2
    while (list1 != null && list2 != null) {
        if (list1.`val` <= list2.`val`) {
            pre?.next = list1
            list1 = list1.next
        } else {
            pre?.next = list2
            list2 = list2.next
        }
        pre = pre?.next
    }
    pre?.next = list1 ?: list2
    return head?.next
}

// 递归法
fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
    return when {
        l1 == null -> l2
        l2 == null -> l1
        l1.`val` <= l2.`val` -> {
            l1.next = mergeTwoLists2(l1.next, l2)
            l1
        }
        else -> {
            l2.next = mergeTwoLists2(l1, l2.next)
            l2
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}