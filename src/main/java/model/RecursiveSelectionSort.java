package model;

import myLibrary.RecursionCounter;

public class RecursiveSelectionSort {

    /**
     * Method which returns minimum index
     * @param a
     * @param i
     * @param j
     * @return
     */
    static int minIndex(int[] a, int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k])? i : k;
    }

    /**
     * Method that implements recursive selection sort.
     * @param a --> array to sort
     * @param n --> array's length
     * @param index --> index of starting element
     * @param counter --> counts how many time function recurSelectionSort is recalled
     */
    public static void recurSelectionSort(int[] a, int n, int index, RecursionCounter counter)
    {
        //Count how many times the method is recalled
        counter.addusage("recurSelectionSort");

        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);

        // Swapping when index nd minimum index are not same
        if (k != index){
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        recurSelectionSort(a, n, index + 1, counter);
    }

}
