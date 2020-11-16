package geektime.high.frequency.top30

/**
 * 208. 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
fun main() {
    val obj = Trie()
    obj.insert("word")
    println(obj.search("word"))
    println(obj.startsWith("woe"))

    obj.insert("apple")
    println(obj.search("apple"))
    println(obj.startsWith("ap"))
}

class Trie {

    private var isEnd: Boolean = false
    var next = arrayOfNulls<Trie>(26)

    fun insert(word: String) {
        var node = this
        word.forEach {
            val index = getIndex(it)
            if (index !in 0 until 26) return
            if (node.next[index] == null) {
                node.next[index] = Trie()
            }
            node = node.next[index]!!
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node = this
        word.forEach {
            val index = getIndex(it)
            if (index !in 0 until 26) return false
            node = node.next[index] ?: return false
        }
        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node = this
        prefix.forEach {
            val index = getIndex(it)
            if (index !in 0 until 26) return false
            node = node.next[index] ?: return false
        }
        return true
    }

    private fun getIndex(c: Char): Int {
        return c - 'a'
    }

}