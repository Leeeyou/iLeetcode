package type;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] intArray = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(intArray, 8);
        for (int i : leastNumbers) {
            System.out.print(i + " ");
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数，下标为k-1代表总共是k个数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ; // 找到第一个nums[i]>=v的数，i往右靠
            while (--j >= lo && nums[j] > v) ; // 找到第一个nums[j]<=v的数，j往左靠
            if (i >= j) {
                break;
            }
            // 找到了nums[i]>=v且nums[j]<=v的数，则交换i和j的值
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}
