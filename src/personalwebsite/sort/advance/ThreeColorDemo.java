package personalwebsite.sort.advance;

import java.util.Arrays;

/**
 * Created by leeyou on 2016/2/19.三色排序问题
 * <p>
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * 测试样例：
 * [0,1,1,0,2,2],6
 * 返回：[0,0,1,1,2,2]
 */
public class ThreeColorDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 0, 2, 2};
        System.out.print(Arrays.toString(sort(nums, nums.length)));
    }

    public static int[] sort(int[] nums, int n) {
        int l = -1, r = n;
        int index = 0;
        while (index < r) {
            if (nums[index] == 0) {
                swap(nums, ++l, index++);
            } else if (nums[index] == 2) {
                swap(nums, index, --r);
            } else {
                index++;
            }
        }
        return nums;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
