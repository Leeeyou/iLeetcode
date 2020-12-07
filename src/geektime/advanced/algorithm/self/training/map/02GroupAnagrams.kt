package geektime.advanced.algorithm.self.training.map

import java.util.*

/**
 * 49. 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/
 */
fun main() {
//    val result = groupAnagrams(arrayOf())
    val result = groupAnagrams2(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    result.forEach {
        println(it)
    }
}

// 排序数组分类
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, List<String>>()
    strs.forEach {
        val charArray = it.toCharArray()
        Arrays.sort(charArray)
        val key = String(charArray)
        if (!map.containsKey(key)) map[key] = mutableListOf()
        (map[key] as MutableList<String>).add(it)
    }
    val result = mutableListOf<List<String>>()
    map.values.forEach { result.add(it) }
    return result
}

// 按计数分类
fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, List<String>>()
    val count = IntArray(26)
    strs.forEach {
        // 清空数组
        Arrays.fill(count, 0)

        // 统计字母个数
        for (i in it) count[i - 'a']++

        // 生成key
        val sb: StringBuilder = StringBuilder()
        for (j in 0 until 26) {
            sb.append("#")
            sb.append(count[j])
        }
        val key = sb.toString()

        // 根据key检查map
        if (!map.containsKey(key)) map[key] = mutableListOf()
        (map[key] as MutableList<String>).add(it)
    }
    val result = mutableListOf<List<String>>()
    map.values.forEach { result.add(it) }
    return result
}






