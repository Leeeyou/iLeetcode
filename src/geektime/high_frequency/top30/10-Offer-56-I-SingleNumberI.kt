package geektime.high_frequency.top30

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
fun main() {
//    val res = singleNumbers(intArrayOf(2, 2, 3, 3, 4, 6))
//    val res = singleNumbers(intArrayOf(1, 2, 10, 4, 1, 4, 3, 3))
    val res = singleNumbers(intArrayOf())
//    val res = singleNumbers(intArrayOf(2, 3))
    res.forEach { print("$it ") }
}

/**
 * 如果我们可以把所有数字分成两组，使得：
 *  1. 两个只出现一次的数字在不同的组中
 *  2. 相同的数字会被分到相同的组中
 * 那么对两个组分别进行异或操作，即可得到答案的两个数字
 */
fun singleNumbers(nums: IntArray): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    var tmp = 0 // 用于将所有的数异或起来
    for (i in nums) {
        tmp = i.xor(tmp)
    }

    // 获得tmp中最低位的1
    // 例如tmp=0100，那么mask要左移两次才能得到最低位的1
    var mask = 1
    while (tmp.and(mask) == 0) {
        mask = mask.shl(1) // 左移
    }

    var a = 0
    var b = 0
    for (i in nums) {
        // 通过&mask操作，将最低位为1的数字分成两组
        if (i.and(mask) == 0) {
            a = a.xor(i)
        } else {
            b = b.xor(i)
        }
    }

    return intArrayOf(a, b)
}