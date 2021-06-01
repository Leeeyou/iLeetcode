package personalwebsite.sort;

public class MergeSortDemo {

    public static void main(String[] args) {
        MergeSortDemo demo = new MergeSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        demo.mergeSort(array1, 0, array1.length - 1);
        demo.print(array1);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2};
        demo.mergeSort(array2, 0, array2.length - 1);
        demo.print(array2);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        mergeArray(nums, l, mid, r);
    }

    public void mergeArray(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int l = low, r = mid + 1, index = 0;

        // 左右子数组中的小数值放到临时数组中
        while (l <= mid && r <= high) temp[index++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
        // 剩余的直接放入
        while (l <= mid) temp[index++] = nums[l++];
        while (r <= high) temp[index++] = nums[r++];

        // 将临时数组放到原数组
        index = 0;
        while ((low + index) <= high) nums[low + index] = temp[index++];
    }

    private void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
