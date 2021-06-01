package personalwebsite.sort;

public class SelectionSortDemo {

    public static void main(String[] args) {
        SelectionSortDemo demo = new SelectionSortDemo();

        int[] array1 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        demo.selectionSort(array1);
        demo.print(array1);

        int[] array2 = {3, 44, 38, 5, 47, 15, 2};
        demo.selectionSort(array2);
        demo.print(array2);
    }

    public void selectionSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j; // 找到最小的数，保存下标
                }
            }
            startSwap(array, i, min);
        }
    }

    private void startSwap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
