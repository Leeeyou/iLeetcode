package personalwebsite.string;

import java.util.*;

/**
 * Created by LeeeYou on 2016/3/14. 合法括号序列判断练习题
 * <p>
 * [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
 * <p>
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class BracketsDemo {

    public static void main(String[] args) {
        BracketsDemo demo = new BracketsDemo();

        String s1 = "()[]{}(({}))";
        String s2 = "(]";
        String s3 = "()";

        System.out.println();
        System.out.println(demo.isValid(s1));
        System.out.println(demo.isValid(s2));
        System.out.println(demo.isValid(s3));

        System.out.println();
        System.out.println(demo.isValid2(s1));
        System.out.println(demo.isValid2(s2));
        System.out.println(demo.isValid2(s3));

        System.out.println();
        System.out.println(demo.isValid3(s1));
        System.out.println(demo.isValid3(s2));
        System.out.println(demo.isValid3(s3));
    }

    // 栈 + 辅助HashMap
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // 栈（不用辅助HashMap）
    public boolean isValid2(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.empty() || c != stack.pop()) return false;
        }
        return stack.empty();
    }

    // 替换法
    public boolean isValid3(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
        }
        return s.length() == 0;
    }

}
