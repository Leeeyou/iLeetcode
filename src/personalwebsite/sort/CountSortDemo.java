package personalwebsite.sort;

public class CountSortDemo {

    public static void main(String[] args) {
        CountSortDemo demo = new CountSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] array1Result = demo.countSort(array1);
        demo.print(array1Result);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2, 47};
        int[] array2Result = demo.countSort(array2);
        demo.print(array2Result);
    }

    public int[] countSort(int[] a) {
        int[] b = new int[a.length];
        int max = a[0], min = a[0];
        for (int i : a) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int[] c = new int[k];
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1; // 优化过的地方，减小了数组c的大小
        }
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1]; // 对所有的计数累加
        }
        for (int i = a.length - 1; i >= 0; --i) {
            b[--c[a[i] - min]] = a[i]; // 按存取的方式取出c的元素
        }
        return b;
    }

    private void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
