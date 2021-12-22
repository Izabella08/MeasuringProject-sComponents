package measurements;

import java.util.Stack;
import java.util.Timer;

public class MyTimer {

    private static ThreadLocal<Stack<StackEntry>> threadLocal = new ThreadLocal<Stack<StackEntry>>();

    private static Stack<StackEntry> getStack() {
        if (threadLocal.get() == null) {
            threadLocal.set(new Stack<StackEntry>());
        }
        return threadLocal.get();
    }

    /**
     * Method to start measuring time
     */
    public static void timeIt() {
        timeIt("");
    }

    /**
     * Method to start measuring time along with measuring message that you wish to be logged when measuring is finished
     *
     * @param message --> message to logged when measuring is finished
     */
    public static void timeIt(String message) {
        StackEntry entry = new StackEntry(System.currentTimeMillis(), message);
        getStack().push(entry);
    }

    /**
     * Method to end the time measuring and log the message passed at the time of measuring start
     */
    public static long timeUp() {
        if (!getStack().isEmpty()) {
            long currentMillis = System.currentTimeMillis();
            StackEntry stackEntry = getStack().pop();

            System.out.println(stackEntry.getMessage() + ": " + (currentMillis - stackEntry.getTime()) + " milliseconds");
            return currentMillis - stackEntry.getTime();
            //"TIME " +
        }
        return -1;
    }

    /**
     * Method to return the time taken from starting measuring and now in milliseconds
     *
     * @return time --> time elapsed between starting the measuring and now in milliseconds
     */
    public static long timeTaken() {
        long timeTaken = 0;

        if (!getStack().isEmpty()) {
            long currentMillis = System.currentTimeMillis();
            StackEntry stackEntry = getStack().pop();
            timeTaken = currentMillis - stackEntry.getTime();
        }

        return timeTaken;
    }

}
