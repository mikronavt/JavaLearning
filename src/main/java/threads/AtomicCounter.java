package threads;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter {
    private AtomicLong count;

    public AtomicCounter(long count){
        this.count = new AtomicLong(count);
    }

    public long increment() {
        return count.incrementAndGet();
    }

    public long getCount() {
        return count.get();
    }
}
