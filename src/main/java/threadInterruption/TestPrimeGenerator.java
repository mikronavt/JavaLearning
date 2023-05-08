package threadInterruption;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestPrimeGenerator {
    public static final int timeForGeneration = 30;

    public void testPrimeGenerator() throws InterruptedException{
        PrimeGenerator primeGenerator = new PrimeGenerator();
        Thread t = new Thread(primeGenerator);
        t.start();
        Thread.sleep(timeForGeneration);
        t.interrupt();
        List<BigInteger> primes = primeGenerator.getPrimes();
        primes.forEach(prime -> System.out.println("Сгенерировано простое число: " + prime));

    }

    public void testPrimeGeneratorBQ() throws InterruptedException {
        int countOfNumbers = 100;
        BlockingQueue<BigInteger> bq = new ArrayBlockingQueue<>(10);
        PrimeGeneratorBQ primeGeneratorBQ = new PrimeGeneratorBQ(bq);
        Thread t = new Thread(primeGeneratorBQ);
        t.start();
        bq = primeGeneratorBQ.getPrimes();
        for (int i = 0; i < countOfNumbers; i++) {
            System.out.println("Сгенерировано простое число: " + bq.take());
        }
        t.interrupt();
    }
}
