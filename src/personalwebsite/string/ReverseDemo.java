package personalwebsite.string;

import java.util.*;

/**
 * Created by LeeeYou on 2016/3/13. 句子的逆序练习题
 * <p>
 * [LeetCode 151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)
 * <p>
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * 测试样例：
 * "dog loves pig",13
 * 返回："pig loves dog"
 */
public class ReverseDemo {

    public static void main(String[] args) {
        ReverseDemo demo = new ReverseDemo();

        String str1 = "dog loves pig";
        String str2 = "I'm a pig.";
        String str3 = " a good   example ";

        System.out.println(demo.reverseWords(str1));
        System.out.println(demo.reverseWords(str2));
        System.out.println(demo.reverseWords(str3));

        System.out.println();
        System.out.println(demo.reverseWords2(str1));
        System.out.println(demo.reverseWords2(str2));
        System.out.println(demo.reverseWords2(str3));

        System.out.println();
        System.out.println(demo.reverseWords3(str1));
        System.out.println(demo.reverseWords3(str2));
        System.out.println(demo.reverseWords3(str3));
    }

    // 双端队列法
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') ++left; // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(right) == ' ') --right;  // 去掉字符串末尾的空白字符

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }

    // 系统api
    public String reverseWords2(String s) {
        if (s.isEmpty()) return null;
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    // 两次翻转法
    public String reverseWords(String s) {
        if (s.isEmpty()) return null;
        String[] strArray = reverse(s).split("\\s+"); // 按空格切割字符串
        String[] result = new String[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = reverse(strArray[i]);
        }
        return String.join(" ", result);
    }

    public String reverse(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < len / 2) {
            swap(chars, i, len - i - 1);
            ++i;
        }
        return new String(chars);
    }

    public void swap(char[] chars, int i, int j) {
        chars[i] = (char) (chars[i] ^ chars[j]);
        chars[j] = (char) (chars[i] ^ chars[j]);
        chars[i] = (char) (chars[i] ^ chars[j]);
    }
}
