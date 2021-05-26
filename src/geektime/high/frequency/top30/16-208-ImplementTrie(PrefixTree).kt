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

    // 定义类 Trie
    var isEnd: Boolean = false
    var next = arrayOfNulls<Trie>(26)

    /**
     *  首先从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，
     *  这时开始不断开辟新的结点，直到插入完 word 的最后一个字符，同时还要将最后一个结点isEnd = true;
     *  表示它是一个单词的末尾
     */
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

    /**
     * 从根结点的子结点开始，一直向下匹配即可，如果出现结点值为空就返回 false，
     * 如果匹配到了最后一个字符，那我们只需判断 node->isEnd即可。
     */
    fun search(word: String): Boolean {
        var node = this
        word.forEach {
            val index = getIndex(it)
            if (index !in 0 until 26) return false
            node = node.next[index] ?: return false
        }
        return node.isEnd
    }

    /**
     * 和 search 操作类似，只是不需要判断最后一个字符结点的isEnd，
     * 因为既然能匹配到最后一个字符，那后面一定有单词是以它为前缀的。
     */
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