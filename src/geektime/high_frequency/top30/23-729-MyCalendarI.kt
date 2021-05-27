package geektime.high_frequency.top30

import java.util.*


/**
 * 729. 我的日程安排表 I
 *
 * https://leetcode-cn.com/problems/my-calendar-i/
 */
fun main() {
    val myCalendar = MyCalendar()
    println(myCalendar.book(47, 50))
    println(myCalendar.book(33, 41))
    println(myCalendar.book(39, 45))
    println(myCalendar.book(33, 42))
    println(myCalendar.book(25, 32))
    println(myCalendar.book(26, 35))
    println(myCalendar.book(3, 8))
    println(myCalendar.book(8, 13))
    println(myCalendar.book(18, 27))
}

class MyCalendar() {
    var calendar: TreeMap<Int, Int>? = null

    init {
        calendar = TreeMap()
    }

    fun book(start: Int, end: Int): Boolean {
        val prev = calendar?.floorKey(start) // 返回最大键小于或等于给定键
        val next = calendar?.ceilingKey(start) // 返回最小键大于或等于给定键
        if ((prev == null || calendar?.get(prev)!! <= start) && (next == null || end <= next)) {
            calendar?.put(start, end)
            return true
        }
        return false
    }
}