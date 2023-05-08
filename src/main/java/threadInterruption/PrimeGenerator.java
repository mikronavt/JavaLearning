package threadInterruption;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrimeGenerator implements Runnable{
    private final List<BigInteger> primes = new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while(!Thread.currentThread().isInterrupted()) {
            p = p.nextProbablePrime();
            primes.add(p);
        }
    }

    public List<BigInteger> getPrimes() {
        return primes;
    }
}
