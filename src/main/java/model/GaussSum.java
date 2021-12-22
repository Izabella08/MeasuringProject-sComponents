package model;

import measurements.RecursionCounter;

public class GaussSum {

    /**
     * Method for Gauss sum
     * @param n --> the number of elements wanted for the Gauss Sum
     * @param counter --> counts how many time function gaussSum is recalled
     * @return
     */
    public Integer gaussSum(Integer n, RecursionCounter counter){
        //Count how many times the method is recalled
        counter.addusage("gaussSum");
        if (n==1)
            return 1;
        else
            return gaussSum(n-1, counter)+n;
    }
}
