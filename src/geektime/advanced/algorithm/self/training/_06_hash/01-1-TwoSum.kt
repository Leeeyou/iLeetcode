package geektime.advanced.algorithm.self.training._06_hash

/**
 * 1. 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/
 */
fun main() {
    twoSum(intArrayOf(8, 9, 4, 5), 10).forEach { print("$it ") }
    println()
    twoSum(intArrayOf(2, 7, 11, 15), 9).forEach { print("$it ") }
    println()
    twoSum(intArrayOf(3, 2, 4), 6).forEach { print("$it ") }
    println()
    twoSum(intArrayOf(3, 3), 6).forEach { print("$it ") }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val r = IntArray(2) { -1 }
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, v -> map[v] = index }
    nums.forEachIndexed { index, v ->
        val left = target - v
        if (map.containsKey(left) && map[left] != index) {
            r[0] = index
            r[1] = map[left]!!
        }
    }
    return r
}