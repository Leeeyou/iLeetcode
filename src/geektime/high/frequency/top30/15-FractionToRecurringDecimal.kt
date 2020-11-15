package geektime.high.frequency.top30

import java.lang.StringBuilder
import kotlin.math.abs

/**
 * 166. 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
fun main() {
//    println(fractionToDecimal(1, 3))
    println(fractionToDecimal(1, -3))
//    println(fractionToDecimal(-1, 3))
//    println(fractionToDecimal(0, 3))
//    println(fractionToDecimal(3, 0))
//    println(fractionToDecimal(30, 5))
//    println(fractionToDecimal(2147483640, -5))
}

fun fractionToDecimal(numerator: Int, denominator: Int): String {
    val res = StringBuilder()
    if (numerator == 0 || denominator == 0) {
        return "0"
    }

    // false xor false = false , false xor ture = true , true xor false = true , true xor true = false
    // numerator与denominator之间正负号不同，才会进入if分支
    if ((numerator < 0).xor((denominator < 0))) {
        res.append("-")
    }

    val dividend = abs(numerator.toLong()) // 转成正数操作
    val divisor = abs(denominator.toLong()) // 转成正数操作
    res.append((dividend / divisor).toString()) // 直接出发运算，得到小数点左边的数
    var remainder = dividend.rem(divisor)
    if (remainder == 0L) {
        return res.toString()
    }

    res.append(".") // 没有整除，则拼装小数点
    val map = mutableMapOf<Long, Int>() // 记录【余数-res长度】的映射关系
    while (remainder != 0L) {
        if (map.containsKey(remainder)) {
            res.insert(map[remainder]!!.toInt(), "(")
            res.append(")")
            break
        }

        map[remainder] = res.length
        remainder *= 10
        res.append(remainder / divisor) // 拼装余数
        remainder = remainder.rem(divisor)
    }

    return res.toString()
}