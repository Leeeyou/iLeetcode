package type.backtracking.medium

import java.util.*


/**
 * 93. 复原 IP 地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */

fun main() {
    System.out.println(restoreIpAddresses("123456").toString())
}

var res: MutableList<String> = ArrayList()
var temp: MutableList<String> = ArrayList() // temp用于将原字符串截取分成四段

fun restoreIpAddresses(s: String): List<String> {
    val n = s.length
    if (n <= 3 || n >= 13) {
        return res
    }
    dfs(s, 0)
    return res
}

fun dfs(s: String, begin: Int) {
    // 找到目标ip，增加.使符合输出要求，然后return
    if (begin == s.length && temp.size == 4) {
        var str = temp[0]
        for (i in 1..3) {
            str = str + '.' + temp[i]
        }
        res.add(str)
        return
    }

    // 找到4个合适的片段，但是没耗尽字符串，直接return
    if (begin < s.length && temp.size == 4) {
        return
    }

    for (len in 1..3) {
        // 保证后续s.substring(begin,begin+len)合法
        if (begin + len - 1 >= s.length) {
            return
        }

        // 剔除不合法的前导0
        if (len != 1 && s[begin] == '0') {
            return
        }

        // 截取字符串
        val st = s.substring(begin, begin + len)
        // 截取的字符串长度为3时，大小不能超过255
        if (len == 3 && st.toInt() > 255) {
            return
        }
        temp.add(st)

        // 递归
        dfs(s, begin + len)

        // 剪掉不合适的分支，或者已经是目标的分支
        temp.removeAt(temp.size - 1)
    }
}
