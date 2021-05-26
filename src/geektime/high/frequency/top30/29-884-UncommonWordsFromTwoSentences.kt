package geektime.high.frequency.top30

/**
 * 884. 两句话中的不常见单词
 *
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */
fun main() {
    uncommonFromSentences("this apple is sweet", "this apple is sour").forEach {
        println(it)
    }
}

fun uncommonFromSentences(A: String, B: String): Array<String> {
    val count = hashMapOf<String, Int>()
    A.split(" ").forEach {
        count[it] = count.getOrDefault(it, 0).plus(1)
    }
    B.split(" ").forEach {
        count[it] = count.getOrDefault(it, 0).plus(1)
    }
    val mutableListOf = mutableListOf<String>()
    count.forEach {
        if (it.value == 1)
            mutableListOf.add(it.key)
    }
    return mutableListOf.toTypedArray()
}