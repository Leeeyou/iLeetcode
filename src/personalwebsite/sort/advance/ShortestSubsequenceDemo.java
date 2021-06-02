package personalwebsite.sort.advance;

/**
 * Created by leeyou on 2016/2/19.最短子数组
 * <p>
 * [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/)
 * <p>
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：2
 */
public class ShortestSubsequenceDemo {

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 6, 5, 9, 10};
        int[] nums2 = {2, 1};
        int[] nums3 = {1, 2, 3, 4};
        int[] nums4 = {};
        System.out.println(subsequence(nums1, nums1.length));
        System.out.println(subsequence(nums2, nums2.length));
        System.out.println(subsequence(nums3, nums3.length));
        System.out.println(subsequence(nums4, nums4.length));
        System.out.println(subsequence(null, 0));
    }

    public static int subsequence(int[] nums, int n) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0];
        int right = 0;
        // 从左到右找局部最大值，找到最右边小于最大数的下标
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max > nums[i]) right = i;
        }

        if (right == 0) return 0;

        int min = nums[n - 1];
        int left = 0;
        // 从右到左找局部最小值，找到最左边大于最小数的下标
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (min < nums[i]) {
                left = i;
            }
        }

        return right - left + 1;
    }

}
