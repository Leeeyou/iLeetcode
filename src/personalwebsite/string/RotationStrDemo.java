package personalwebsite.string;

/**
 * Created by LeeeYou on 2016/3/13. 两串旋转练习题
 * <p>
 * [LeetCode 796. 旋转字符串](https://leetcode-cn.com/problems/rotate-string/)
 * <p>
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 * 测试样例：
 * "cdab",4,"abcd",4
 * 返回：true
 */
public class RotationStrDemo {

    public static void main(String[] args) {
        RotationStrDemo demo = new RotationStrDemo();
        System.out.println(chkRotation("love", 5, "elo", 5));
        System.out.println(demo.rotateString("love", "elo"));
    }

    public static boolean chkRotation(String str1, int n, String str2, int m) {
        if (n != m) return false;
        String a = str1 + str1;
        return getIndexOf(a, str2) != -1;
    }

    // KMP Algorithm
    public static int getIndexOf(String s, String m) {
        if (s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
