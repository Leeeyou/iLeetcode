package personalwebsite.sort;

public class BubbleSortDemo {

    public static void main(String[] args) {
        BubbleSortDemo demo = new BubbleSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        demo.bubbleSort(array1);
        demo.print(array1);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2};
        demo.bubbleSort(array2);
        demo.print(array2);
    }

    public void bubbleSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;
        for (int i = 0; i < length; ++i) {
            boolean flag = false; // 提前退出冒泡循环的标志位
            for (int j = 0; j < length - i - 1; ++j) {
                if (nums[j] > nums[j + 1]) { // 交换
                    startSwap(nums, j, j + 1);
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换就提前退出
        }
    }

    private void startSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
