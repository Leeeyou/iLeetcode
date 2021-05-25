package medium.architectrue

import java.util.*
import kotlin.collections.HashMap

/**
 * 146. LRU 缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/
 */

class LRUCache(private val capacity: Int) {

    var queue = ArrayDeque<Int>(capacity)
    var map = HashMap<Int, Int>(capacity)

    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            queue.removeLastOccurrence(key)
            queue.offerFirst(key)
            map[key]!!
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key] = value
            queue.removeLastOccurrence(key)
            queue.offerFirst(key)
        } else {
            if (map.size >= capacity) {
                val lastKey = queue.pollLast()
                map.remove(lastKey)
            }
            map[key] = value
            queue.offerFirst(key)
        }
    }

    //// 以下是自定义双向链表

    class DLinkedNode(var key: Int? = null, var value: Int? = null) {
        var prev: DLinkedNode? = null
        var next: DLinkedNode? = null
    }

    var cache = HashMap<Int, DLinkedNode>(capacity)

    // 使用伪头部和伪尾部节点
    var head = DLinkedNode()
    var tail = DLinkedNode()

    init {
        head.next = tail
        tail.prev = head
    }

    fun removeNode(node: DLinkedNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    fun addToHead(node: DLinkedNode) {
        node.prev = head
        node.next = head.next
        node.next?.prev = node
        head.next = node
    }

    fun moveToHead(node: DLinkedNode) {
        removeNode(node)
        addToHead(node)
    }

    fun removeTail(): DLinkedNode {
        val node = tail.prev!!
        removeNode(node)
        return node
    }

    fun get2(key: Int): Int {
        val node = cache[key] ?: return -1
        moveToHead(node)
        return node.value!!
    }

    fun put2(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            cache[key]!!.value = value
            moveToHead(cache[key]!!)
        } else {
            val newNode = DLinkedNode(key, value)
            if (cache.size >= capacity) {
                val tail = removeTail()
                cache.remove(tail.key)
            }
            cache[key] = newNode
            addToHead(newNode)
        }
    }

}