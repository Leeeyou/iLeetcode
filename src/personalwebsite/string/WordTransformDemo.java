package personalwebsite.string;

/**
 * Created by liuzhif on 16/2/21.词语变形
 * <p>
 * [LeetCode 242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
 * <p>
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * 测试样例：
 * "abc",3,"bca",3
 * 返回：true
 */
public class WordTransformDemo {

    public static void main(String[] args) {
        WordTransformDemo demo = new WordTransformDemo();
        String a = "ac";
        String b = "bb";
        System.out.println(demo.isAnagram(a, b));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }

        for (int j : array) {
            if (j != 0) return false;
        }

        return true;
    }

}
