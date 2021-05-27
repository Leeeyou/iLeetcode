package type.search.easy;

/**
 * 剑指 Offer 15. 二进制中1的个数
 *
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */

public class Offer_15_NumberOf1InBinary {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }
}
