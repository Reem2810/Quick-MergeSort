package nl.han.asd;


import java.util.Arrays;
import java.util.Random;

public class QuickSortComparison {
    private static final Random random = new Random();

    public QuickSortComparison() {
    }

    public static void quickSortGoodPivot(int[] array) {
        if (array != null && array.length > 1) {
            quickSortGoodPivot(array, 0, array.length - 1);
        }
    }

    private static void quickSortGoodPivot(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionGoodPivot(array, low, high);
            quickSortGoodPivot(array, low, pivotIndex - 1);
            quickSortGoodPivot(array, pivotIndex + 1, high);
        }

    }

    private static int partitionGoodPivot(int[] array, int low, int high) {
        int pivotIndex = medianOfThreeRandomPivot(array, low, high);
        swap(array, pivotIndex, high);
        int pivot = array[high];
        int i = low;

        for(int j = low; j < high; ++j) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                ++i;
            }
        }

        swap(array, i, high);
        return i;
    }

    private static int medianOfThreeRandomPivot(int[] array, int low, int high) {
        int i1 = low + random.nextInt(high - low + 1);
        int i2 = low + random.nextInt(high - low + 1);
        int i3 = low + random.nextInt(high - low + 1);
        int a = array[i1];
        int b = array[i2];
        int c = array[i3];
        if ((a > b || b > c) && (c > b || b > a)) {
            return (b > a || a > c) && (c > a || a > b) ? i3 : i1;
        } else {
            return i2;
        }
    }

    public static void quickSortBadPivot(int[] array) {
        if (array != null && array.length > 1) {
            quickSortBadPivot(array, 0, array.length - 1);
        }
    }

    private static void quickSortBadPivot(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionBadPivot(array, low, high);
            quickSortBadPivot(array, low, pivotIndex - 1);
            quickSortBadPivot(array, pivotIndex + 1, high);
        }

    }

    private static int partitionBadPivot(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;

        for(int j = low; j < high; ++j) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                ++i;
            }
        }

        swap(array, i, high);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

    public static void main(String[] args) {
        int n = 100000;
        int[] original = new int[n];

        for(int i = 0; i < n; ++i) {
            original[i] = random.nextInt(1000000);
        }

        int[] arrayGood = Arrays.copyOf(original, original.length);
        int[] arrayBad = Arrays.copyOf(original, original.length);

        for(int i = 0; i < 5; ++i) {
            quickSortGoodPivot(Arrays.copyOf(arrayGood, arrayGood.length));
        }

        long startTime = System.nanoTime();
        quickSortGoodPivot(arrayGood);
        long endTime = System.nanoTime();
        System.out.println("QuickSort (Good Pivot) took " + (endTime - startTime) + " ns.");
        startTime = System.nanoTime();
        quickSortBadPivot(arrayBad);
        endTime = System.nanoTime();
        System.out.println("QuickSort (Bad Pivot) took " + (endTime - startTime) + " ns.");
    }
}

