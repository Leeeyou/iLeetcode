package personalwebsite.string;

/**
 * Created by LeeeYou on 2016/3/14. 空格替换练习题
 * <p>
 * [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)
 * <p>
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 */
public class ReplaceDemo {

    public static void main(String[] args) {
        ReplaceDemo demo = new ReplaceDemo();
        System.out.println(demo.replaceSpace("We are happy."));
        System.out.println(demo.replaceSpace2("We are happy."));
    }

    // 系统api
    public String replaceSpace(String s) {
        StringBuilder build = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                build.insert(0, "%20");
            } else {
                build.insert(0, chars[i]);
            }
        }
        return build.toString();
    }

    // 数组
    public String replaceSpace2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') count++;
        }
        char[] cs = new char[s.length() + count * 2];
        int index = cs.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                cs[index--] = '0';
                cs[index--] = '2';
                cs[index--] = '%';
            } else {
                cs[index--] = c;
            }
        }
        return new String(cs);
    }

}
