package measurements;

import java.util.HashMap;

public class RecursionCounter {

    private final HashMap<String,Integer> usage= new HashMap<>();

    /**
     * Method used to compute how many times a function was called recursively
     * @param functionName
     */
    public void addusage(String functionName){
        if (!usage.containsKey(functionName)){
            usage.put(functionName,0);
        }
        Integer x=usage.get(functionName);
        usage.put(functionName,++x);
    }

    /**
     * Method which returns a function's usage
     * @param functionName
     * @return
     */
    public Integer usagetimes(String functionName){
        return usage.get(functionName);
    }


}
