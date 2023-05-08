import strategy.StrategyTest;
import threadInterruption.TestPrimeGenerator;
import threads.ThreadsTest;

public class Main {

    public static void main(String[] args) {
        try {
            new ThreadsTest().testCounter();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
