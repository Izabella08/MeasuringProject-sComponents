package model;

import myLibrary.RecursionCounter;

public class Fibonacci {

    /**
     * Method for fibonacci series
     * @param n --> the number of elements wanted into the Fibonacci series
     * @param counter --> counts how many time function fibonacci is recalled
     * @return
     */
    public Integer fibonacci(Integer n, RecursionCounter counter){
        //Count how many times the method is recalled
        counter.addusage("fibonacci");
        if (n < 2)
            return 1;
        else
            return fibonacci(n - 1,counter) + fibonacci(n - 2,counter);
    }

}
