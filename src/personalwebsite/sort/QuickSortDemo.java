package personalwebsite.sort;

public class QuickSortDemo {
    public static void main(String[] args) {
        QuickSortDemo qs = new QuickSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        qs.quickSort(array1, 0, array1.length - 1);
        qs.print(array1);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2};
        qs.quickSort(array2, 0, array2.length - 1);
        qs.print(array2);
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = partition(nums, low, high); // 分区函数，返回分区点的下标
        quickSort(nums, low, mid - 1); // 递归排序左分区
        quickSort(nums, mid + 1, high); // 递归排序右分区
    }

    private int partition(int[] nums, int low, int hight) {
        int pivot = nums[low]; // 以下标low的值为基准点
        int i = low, j = hight + 1; // j之所以加1是因为下面开始找值的时候，开始就做了--操作
        while (true) {
            while (++i <= hight && nums[i] < pivot) ; // 从左到右找第一个大于等于pivot的值
            while (--j >= low && nums[j] > pivot) ; // 从右到左找第一个小于等于pivot的值
            if (i >= j) break;
            startSwap(nums, i, j);
        }
        nums[low] = nums[j]; // 将mid的值(也就是下标j的值)与pivot交换
        nums[j] = pivot;
        return j;
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
