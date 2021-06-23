package sorting;

import java.util.Arrays;

public class QuickSort {

    /**
     * Merge sort is O(nLogn) but takes space complexity of O(N).
     * Quick sort provides average case O(NLogN) but space complexity of O(1).
     * The worst case time complexity is still O(n^2) but we can avoid that by implementing randomized quick sort.
     *
     * In-place but Not a stable algorithm as swapping is done wrt pivot element and not the original order of the list.
     * Cache friendly algorithm as it stays in bounds of the list in memory.
     *
     * Sort function of most programming languages uses quick sort.
     *
     * At each step, we chose a pivot element and try to bring it to its correct position.
     * Choosing the pivot? Choose the right most element, or a random element (Randomized Quicksort)
     *
     * Once a pivot is chosen, we bring smaller elements to its left and higher to its right.
     *
     * Recursively solve the above problem until sorted.
     *
     * BASE CASE ? Size of array == 1
     *
     *
     * Buggy
     */

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 3, 1, 7, 9, 6, 5, 0};
        System.out.println(Arrays.toString(quickSort(array, 0, array.length)));
    }

    private static int[] quickSort(int[] array, int start, int end) {
        System.out.println("quickSort");
        if (start >= end) {
            return null;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivotIndex = 0;
        for (int i = start; i < end - 1; i++) {
            if (array[i] <= array[pivotIndex]) {
                int temp = array[i];
                array[i] = array[pivotIndex];
                array[pivotIndex] = temp;
                pivotIndex++;
            }
        }
        int temp = array[array.length - 1];
        array[array.length - 1] = array[pivotIndex];
        array[pivotIndex] = temp;
        System.out.println(pivotIndex);
        return pivotIndex;
    }


}
