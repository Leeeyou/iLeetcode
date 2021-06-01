package personalwebsite.sort;

public class ShellSortDemo {

    public static void main(String[] args) {
        ShellSortDemo demo = new ShellSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        demo.shellSort(array1);
        demo.print(array1);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2};
        demo.shellSort(array2);
        demo.print(array2);
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

    private void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
