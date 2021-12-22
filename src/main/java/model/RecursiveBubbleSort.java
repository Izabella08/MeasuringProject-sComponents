package model;

import measurements.RecursionCounter;

public class RecursiveBubbleSort {

    /**
     * Method to sort an array using bubble sort
     * @param arr --> array to sort
     * @param n --> array's length
     * @param counter --> counts how many times the function bubbleSort is recalled
     */
    public void bubbleSort(int[] arr, int n, RecursionCounter counter)
    {
        //Count how many times the method is recalled
        counter.addusage("bubbleSort");

        // Base case
        if (n == 1)
            return;

        // One pass of bubble sort. After this pass, the largest element is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

        // Largest element is fixed, recur for remaining array
        bubbleSort(arr, n-1, counter);
    }
}
