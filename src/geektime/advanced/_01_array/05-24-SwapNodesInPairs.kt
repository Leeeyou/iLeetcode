package geektime.advanced._01_array

/**
 * 24. 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
fun main() {
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(3)
    listNode.next?.next?.next = ListNode(4)
    var swapPairs = swapPairs(listNode)
    while (swapPairs != null) {
        println(swapPairs.`val`)
        swapPairs = swapPairs.next
    }
}

// 迭代法
fun swapPairs(head: ListNode?): ListNode? {
    val dummyNode = ListNode(Int.MAX_VALUE)
    dummyNode.next = head
    var temp: ListNode? = dummyNode
    while (temp?.next != null && temp.next?.next != null) {
        val last = temp.next
        val fast = temp.next?.next

        temp.next = fast
        last?.next = fast?.next
        fast?.next = last

        temp = last
    }
    return dummyNode.next
}