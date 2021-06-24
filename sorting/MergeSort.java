package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    /**
     *
     */

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 3, 1, 7, 9, 6, 5,  0};
        System.out.println(Arrays.toString(mergeSort(array, 0, array.length)));
    }

    private static int[] mergeSort(int[] array, int start, int end) {
        ArrayList list = new ArrayList();
        
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            return mergeArrays(array, start, mid, end);
        } else {
            return null;
        }
    }

    private static int[] mergeArrays(int[] Arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j < end) {
            if (Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1;
                i += 1;
            } else {
                temp[k] = Arr[j];
                k += 1;
                j += 1;
            }
        }

        // add elements left in the first array
        while (i <= mid) {
            temp[k] = Arr[i];
            k += 1;
            i += 1;
        }

        // add elements left in the second array
        while (j < end) {
            temp[k] = Arr[j];
            k += 1;
            j += 1;
        }

        for (i = start; i < end; i += 1) {
            Arr[i] = temp[i - start];
        }
        return Arr;
    }
}
