package geektime.advanced.algorithm.self.training.binary_search

/**
 * 50. Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/
 */
fun main() {
//    println(myPow(2.0, 10))
    println(myPow2(2.0, 7))
//    println(myPow(3.0, 10))
//    println(myPow(3.0, 0))
//    println(myPow(0.0, 0))
//    println(myPow(2.0, -4))
}

/**
 * 快速幂 + 递归
 * 时间复杂度：O(logn)，即为递归的层数。
 * 空间复杂度：O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
 */
fun myPow(x: Double, n: Int): Double {
    val N = n.toLong()
    return if (n > 0) quickMul(x, N) else 1.0 / quickMul(x, -N)
}

fun quickMul(x: Double, n: Long): Double {
    if (n == 0L) {
        return 1.0
    }
    val y = quickMul(x, n / 2)
    return if (n.rem(2) == 0L) y * y else y * y * x
}

/**
 * 快速幂 + 迭代
 * 时间复杂度：O(logn)，即为递归的层数。
 * 空间复杂度：O(1)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
 */
fun myPow2(x: Double, n: Int): Double {
    val N = n.toLong()
    return if (n > 0) quickMul2(x, N) else 1.0 / quickMul2(x, -N)
}

/**
 * 可以debug好好体会一下，例如2的7次方
 * 7的二进制为111，那么会要计入3次贡献
 * 第一次：贡献2
 * 第二次：贡献4
 * 第三次：贡献16
 * 2*4*16=128
 */
fun quickMul2(x: Double, n: Long): Double {
    var N = n
    var ans = 1.0
    // 贡献的初始值为 x
    var xContribute = x
    // 在对 N 进行二进制拆分的同时计算答案
    while (N > 0) {
        if (N % 2 == 1L) {
            // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
            ans *= xContribute
        }
        // 将贡献不断地平方
        xContribute *= xContribute
        // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
        N /= 2
    }
    return ans
}