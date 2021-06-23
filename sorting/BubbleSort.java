package sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Bubble up the largest possible number in the array.
     * <p>
     * One of the most fundamental sorting algorithms, with worst case O(N^2) and O(N) in best case.
     * O(1) is space complexity.
     * <p>
     * Fastest ways to check if a list is already sorted.
     * <p>
     * INPLACE, STABLE, sorting algorithm.
     * It is about four times as slow as insertion sort and twice as slow as selection sort.
     */

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSort(array, 0, array.length)));
    }

    /**
     * {4, 6, 8, 3, 1, 7, 9, 6, 5, 0}
     * <p>
     * <p>
     * {0, 1, 3, 8, 6, 7, 9, 6, 5, 4}
     */

    private static int[] bubbleSort(int[] array, int start, int end) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
