package leetcode.sort.easy

/**
 * 1122. 数组的相对排序
 *
 * https://leetcode-cn.com/problems/relative-sort-array/
 */

fun main() {
    // 2,2,2,1,4,3,3,9,6,7,19
//    val array1 = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
//    val array2 = intArrayOf(2, 1, 4, 3, 9, 6)
//    val result = relativeSortArray(array1, array2)
//    result.forEach { System.out.print("$it ") }

    val array1 = intArrayOf(28, 6, 22, 8, 44, 17)
    val array2 = intArrayOf(22, 28, 8, 6)
    val result = relativeSortArray(array1, array2)
    result.forEach { System.out.print("$it ") }
}

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val bucket = IntArray(1001)
    val result = mutableListOf<Int>()
    arr1.forEach {
        bucket[it] += 1
    }

    arr2.forEach {
        var count = bucket[it]
        while (count > 0) {
            result.add(it)
            count--
        }
        bucket[it] = 0
    }

    bucket.forEachIndexed { index, value ->
        var count = value
        while (count > 0) {
            result.add(index)
            count--
        }
        bucket[index] = 0
    }

    return result.toIntArray()
}