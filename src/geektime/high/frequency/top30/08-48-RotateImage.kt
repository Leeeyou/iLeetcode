package geektime.high.frequency.top30

/**
 * 48. 旋转图像
 *
 * https://leetcode-cn.com/problems/rotate-image/
 */
fun main() {
//    val matrix = arrayOf(
//        intArrayOf(1, 2, 3, 4, 5),
//        intArrayOf(6, 7, 8, 9, 10),
//        intArrayOf(11, 12, 13, 14, 15),
//        intArrayOf(16, 17, 18, 19, 20),
//        intArrayOf(21, 22, 23, 24, 25)
//    )
//    printMatrix(matrix)
//    println("---")
//    rotate(matrix)
//    printMatrix(matrix)

//    val matrix2 = arrayOf(
//        intArrayOf(1, 2, 3),
//        intArrayOf(4, 5, 6),
//        intArrayOf(7, 8, 9)
//    )
//    printMatrix(matrix2)
//    println("---")
//    rotate(matrix2)
//    printMatrix(matrix2)

//    val matrix3 = arrayOf(
//        intArrayOf(1, 2),
//        intArrayOf(3, 4)
//    )
//    printMatrix(matrix3)
//    println("---")
//    rotate(matrix3)
//    printMatrix(matrix3)

//    val matrix4 = arrayOf(
//        intArrayOf(3)
//    )
//    printMatrix(matrix4)
//    println("---")
//    rotate(matrix4)
//    printMatrix(matrix4)

    val matrix5 = arrayOf(
        intArrayOf()
    )
    printMatrix(matrix5)
    println("---")
    rotate(matrix5)
    printMatrix(matrix5)
}

fun printMatrix(matrix: Array<IntArray>) {
    val size = matrix[0].size
    for (i in 0 until size) {
        for (j in 0 until size) {
            print("${matrix[i][j]} ")
            if (j < size - 1) {
                print(", ")
            }
        }
        println()
    }
}

fun rotate(matrix: Array<IntArray>): Unit {
    var p1 = 0
    var p2 = matrix[0].size - 1
    var step: Int
    while (p1 < p2) { // 控制在哪一圈置换
        step = 0
        while (step < p2 - p1) { // 控制该圈的步长
            val temp = matrix[p2 - step][p1]
            matrix[p2 - step][p1] = matrix[p2][p2 - step]  // 左下 [p2 - step][p1]
            matrix[p2][p2 - step] = matrix[p1 + step][p2]  // 右下 [p2][p2 - step]
            matrix[p1 + step][p2] = matrix[p1][p1 + step]  // 右上 [p1 + step][p2]
            matrix[p1][p1 + step] = temp // 左上 [p1][p1 + step]
            step += 1
        }
        p1 += 1
        p2 -= 1
    }
}