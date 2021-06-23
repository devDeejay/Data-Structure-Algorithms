package sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Simplest sorting algorithm.
     *
     * We select the minimum element and put it in place.
     *
     * In Selection Sort, we will split our array into two parts, Sorted and Unsorted arrays.
     * We will pick the minimum element from unsorted array and place it at its best position in sorted array.
     *
     * Space Complexity = O(1)
     * Time Complexity = O(N^2)
     *
     * Simple.
     */

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 3, 1, 7, 9, 6, 5, 0};
        System.out.println(Arrays.toString(selectionSort(array, 0, array.length)));
    }

    /**
     * {4, 6, 8, 3, 1, 7, 9, 6, 5, 0}
     * <p>
     * <p>
     * {0, 1, 8, 3, 6, 7, 9, 6, 5, 4}
     */

    private static int[] selectionSort(int[] array, int start, int end) {
        for (int i = 0; i <= array.length - 1; i++) {
            int minItemIndex = findMinIndex(array, i);
            int temp = array[minItemIndex];
            array[minItemIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    private static int findMinIndex(int[] array, int startIndex) {
        int minIndex = startIndex;
        int min = array[startIndex];
        for (int i = startIndex + 1; i <= array.length - 1; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
