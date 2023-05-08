import strategy.StrategyTest;
import threadInterruption.TestPrimeGenerator;

public class Main {

    public static void main(String[] args) {
        try {
            new TestPrimeGenerator().testPrimeGeneratorBQ();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
