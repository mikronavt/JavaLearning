package threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadsTest {
    private Counter counter;
    private AtomicCounter atomicCounter;

    private class CounterRunner implements Runnable{
       long localCounter = 0;
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()) {
                counter.increment();
                atomicCounter.increment();
                ++localCounter;
            }
        }
    }
    public void testCounter() throws InterruptedException{
        int countOfThreads = 100;
        int waitForCheck = 100;
        counter = new Counter(0);
        atomicCounter = new AtomicCounter(0);
        List<CounterRunner> counterRunners = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < countOfThreads; i++) {
            CounterRunner cr = new CounterRunner();
            counterRunners.add(cr);
            Thread t = new Thread(cr);
            t.start();
            threads.add(t);
        }
        Thread.sleep(waitForCheck);
        threads.forEach(Thread::interrupt);
        long counterToCheck = 0;
        for (int i = 0; i < countOfThreads; i++) {
            System.out.println(i + "-й счетчик насчитал: " + counterRunners.get(i).localCounter);
            counterToCheck+=counterRunners.get(i).localCounter;
        }
        System.out.println("Неатомарный счетчик насчитал: " + counter.getCount());
        System.out.println("Атомарный счетчик насчитал: " + atomicCounter.getCount());
        System.out.println("Проверочный счетчик: " + counterToCheck);
    }
}
