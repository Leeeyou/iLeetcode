package geektime.high.frequency.top30

/**
 * 762. 二进制表示中质数个计算置位
 *
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
fun main() {
    println(countPrimeSetBits(10, 15))
}

fun countPrimeSetBits(L: Int, R: Int): Int {
    var res = 0
    for (i in L..R) {
        if (isSmallPrime(Integer.bitCount(i))) res++
    }
    return res
}


fun isSmallPrime(x: Int): Boolean {
    return x == 2 || x == 3 || x == 5 || x == 7 || x == 11 || x == 13 || x == 17 || x == 19
}
