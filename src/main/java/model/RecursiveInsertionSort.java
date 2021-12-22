package model;

import measurements.RecursionCounter;

public class RecursiveInsertionSort {

    /**
     * Method to sort an array using insertion sort
     * @param arr --> array to sort
     * @param n --> array's length
     * @param counter --> counts how many times function insertionSort is recalled
     */
    public static void insertionSort(int arr[], int n, RecursionCounter counter)
    {
        //Count how many times the method is recalled
        counter.addusage("insertionSort");

        // Base case
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSort( arr, n-1, counter );

        // Insert last element at its correct position in sorted array.
        int last = arr[n-1];
        int j = n-2;

        /* Move elements of arr[0..i-1], that are greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }

}
