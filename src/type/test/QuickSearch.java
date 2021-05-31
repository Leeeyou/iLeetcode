package type.test;

import static type.sort.easy._922_SortArrayByParity_IIKt.swap;

public class QuickSearch {
    public static void main(String[] args) {
        int[] intArray = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] intArray2 = {3, 44, 38, 5, 47, 15, 2};
        QuickSearch quickSearch = new QuickSearch();
        quickSearch.sort(intArray, 0, intArray.length - 1);
        quickSearch.sort(intArray2, 0, intArray2.length - 1);
        print(intArray);
        print(intArray2);
    }

    private static void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void sort(int[] nums, int low, int hight) {
        if (low >= hight) return;
        int mid = partition(nums, low, hight);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, hight);
    }

    private int partition(int[] nums, int low, int hight) {
        int pivot = nums[low];
        int i = low, j = hight + 1;
        while (true) {
            while (++i <= hight && nums[i] < pivot) ;
            while (--j >= low && nums[j] > pivot) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        nums[low] = nums[j];
        nums[j] = pivot;
        return j;
    }


}
