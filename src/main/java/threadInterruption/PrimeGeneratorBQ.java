package threadInterruption;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class PrimeGeneratorBQ implements Runnable{
    private final BlockingQueue<BigInteger> primes;

    public PrimeGeneratorBQ(BlockingQueue<BigInteger> primes) {
        this.primes = primes;
    }

    @Override
    public void run(){
        BigInteger p = BigInteger.ONE;
        try{
            while (!Thread.currentThread().isInterrupted()){
                p = p.nextProbablePrime();
                primes.put(p);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public BlockingQueue<BigInteger> getPrimes() {
        return primes;
    }
}
