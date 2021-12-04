package j.packt.Chapter11.P221_AddersAndAccumulators;

import java.util.concurrent.atomic.LongAccumulator;

public class AtomicAccumulator implements Runnable {

    public static LongAccumulator count = new LongAccumulator(Long::sum, 0);

    @Override
    public void run() {
        count.accumulate(1);
    }

    public long getCount() {
        return count.get();
    }
}
