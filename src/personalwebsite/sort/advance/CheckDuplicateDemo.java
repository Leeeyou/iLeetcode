package personalwebsite.sort.advance;

import java.util.HashSet;

/**
 * Created by liyou on 16/2/17.重复值判断
 * <p>
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 * 测试样例：
 * [1,2,3,4,5,5,6],7
 * 返回：true
 */
public class CheckDuplicateDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 5, 6};
        CheckDuplicateDemo demo = new CheckDuplicateDemo();
        System.out.println(demo.check(nums, nums.length));
        System.out.println(demo.checkDuplicate2(nums));
    }

    public boolean check(int[] a, int n) {
        if (a == null || a.length <= 0) return false;
        shellSort(a);
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) return true;
        }
        return false;
    }

    // 升级版的插入排序
    public void shellSort(int[] nums) {
        int length = nums.length;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                int v = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > v) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = v;
            }
        }
    }

    public boolean checkDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 0) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(i)) return false;
        }
        return true;
    }
}
