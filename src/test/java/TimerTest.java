import myLibrary.MyTimer;
import org.junit.Test;

public class TimerTest {
    @Test
    public void doSomething(){
        MyTimer.timeIt();
        for (int i = 1; i <= 1000; i++){
            System.out.println("Measuring execution");
        }
        MyTimer.timeUp();

    }
}
