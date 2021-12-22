package demos;

import measurements.RecursionCounter;

public class TestsForRecursion {

    /**
     * Method to call the recursive functions
     * @param functionName
     */
    public void initialize(String functionName){
        RecursionCounter counter=new RecursionCounter();
        switch (functionName){
            case "fibonnaci":  fibonacci(10,counter);
                               System.out.println("Usage for Fibonacci: " + counter.usagetimes("fibonacci"));
                               System.out.println("----------------------------------------------------------------------------------------------------");
                break;
            case "gaussSum": gaussSum(100, counter);
                             System.out.println("Usage for Gauss sum: " + counter.usagetimes("gaussSum"));
                             System.out.println("----------------------------------------------------------------------------------------------------");
                break;
            default:
                     System.out.println(counter.usagetimes("fibonacci"));
                     break;
        }
    }

    /**
     * Method to compute Fibonacci series
     * @param n
     * @param counter
     * @return
     */
    public Integer fibonacci(Integer n, RecursionCounter counter){
        counter.addusage("fibonacci");
        if (n < 2)
            return 1;
        else
            return fibonacci(n - 1,counter) + fibonacci(n - 2,counter);
    }

    /**
     * Method to compute gauss sum
     * @param n
     * @param counter
     * @return
     */
    public Integer gaussSum(Integer n, RecursionCounter counter){
        counter.addusage("gaussSum");
        if (n==1)
            return 1;
        else
            return gaussSum(n-1, counter)+n;
    }

}
