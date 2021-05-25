package medium.architectrue

import java.util.*

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
}