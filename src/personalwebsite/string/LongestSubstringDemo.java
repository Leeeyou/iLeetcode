package personalwebsite.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LeeeYou on 2016/3/14. 最长无重复字符子串练习题
 * <p>
 * [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
 * <p>
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 * 测试样例：
 * "aabcb",5
 * 返回：3
 */
public class LongestSubstringDemo {

    public static void main(String[] args) {
        LongestSubstringDemo demo = new LongestSubstringDemo();

        String s1 = "abcabcbb";
        String s2 = "rfrxkfrb";

        System.out.println(demo.lengthOfLongestSubstring(s1));
//        System.out.println(demo.lengthOfLongestSubstring(s2));
    }

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));  // 左指针向右移动一格，移除一个字符
            }
            // 从i位置开始不断地移动右指针找不重复的最长字串
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1); // 第 i 到 rk 个字符是一个极长的无重复字符子串
        }
        return ans;
    }

}
