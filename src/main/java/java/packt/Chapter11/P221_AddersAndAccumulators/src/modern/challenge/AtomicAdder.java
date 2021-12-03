package java.packt.Chapter11.P221_AddersAndAccumulators.src.modern.challenge;

import java.util.concurrent.atomic.LongAdder;

public class AtomicAdder implements Runnable {

    public static LongAdder count = new LongAdder();
    
    @Override
    public void run() {
        count.add(1);
    }

    public long getCount() {
        return count.sum();
    }        
}
