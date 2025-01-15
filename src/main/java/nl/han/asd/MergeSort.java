package nl.han.asd;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class MergeSort {
    public MergeSort() {
    }

    public static void sort(int[] array) {
        if (array != null && array.length > 1) {
            int[] temp = new int[array.length];
            mergeSort(array, temp, 0, array.length - 1);
        }
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        int i;
        for(i = left; i <= right; ++i) {
            temp[i] = array[i];
        }

        i = left;
        int j = mid + 1;

        int k;
        for(k = left; i <= mid && j <= right; ++k) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                ++i;
            } else {
                array[k] = temp[j];
                ++j;
            }
        }

        while(i <= mid) {
            array[k] = temp[i];
            ++i;
            ++k;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{38, 27, 43, 3, 9, 82, 10, 55, 46, 75, 34, 99, 42, 59, 54, 67, 23, 66, 77, 88};
        System.out.println("Before sorting: ");
        printArray(array);
        sort(array);
        System.out.println("After sorting: ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        int[] var1 = array;
        int var2 = array.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int value = var1[var3];
            System.out.print(value + " ");
        }

        System.out.println();
    }
}
