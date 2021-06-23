package sorting;

import java.util.ArrayList;
import java.util.List;


public class InsertionSort {

    /**
     * Very useful in case when the array is partially Sorted ('n' swaps, 'n' comparisons required)
     * O(n^2) but still is more optimal than bubble or selection sort
     * In-place, Stable Sorting Algorithm
     * <p>
     * We start from left, and we keep swapping, we maintain a sorted list at the left side and keep on getting one element from the unsorted array
     */

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(List.of(3, 6, 8, 3, 3, 7, 9, 6, 5, 3));
        insertionSort(myList);
    }

    private static ArrayList<Integer> insertionSort(ArrayList<Integer> myList) {
        for (int i = 1; i < myList.size(); i++) {
            while (myList.get(i - 1) > myList.get(i)) {
                var temp = myList.get(i);
                myList.set(i, myList.get(i - 1));
                myList.set(i - 1, temp);
                i--;
            }
        }
        return myList;
    }
}
