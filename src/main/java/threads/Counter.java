package threads;

public class Counter {
    private long count;

    public Counter(long count){
        this.count = count;
    }

    public long increment(){
        return ++count;
    }

    public long getCount() {
        return count;
    }
}
