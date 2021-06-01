package personalwebsite.sort;

public class InsertionSortDemo {

    public static void main(String[] args) {
        InsertionSortDemo demo = new InsertionSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        demo.insertionSort(array1);
        demo.print(array1);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2};
        demo.insertionSort(array2);
        demo.print(array2);
    }

    public void insertionSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;
        for (int i = 1; i < length; ++i) {
            int v = nums[i];
            int j = i - 1;
            // 找到第一个小于等于v的下标
            while (j >= 0 && nums[j] > v) {
                nums[j + 1] = nums[j];  // 向后移动数据，给v腾出空间
                j--;
            }
            nums[j + 1] = v; // 插入数据
        }
    }

    private void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
