package model;

import myLibrary.RecursionCounter;

public class RecursiveQuickSort {

    /**
     * This function takes last element as pivot, places the pivot element at its correct
     * position in sorted array, and places all smaller (smaller than pivot) to left of
     * pivot and all greater elements to right of pivot
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static Integer partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    /**
     * Method that implements QuickSort
     * @param arr --> array to be sorted
     * @param low --> starting index
     * @param high --> ending index
     * @param counter --> counts how many times funtion quickSort is recalled
     */
    public static void quickSort(int arr[], int low, int high, RecursionCounter counter)
    {
        //Count how many times the method is recalled
        counter.addusage("quickSort");

        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi-1, counter);
            quickSort(arr, pi+1, high, counter);
        }
    }

}
