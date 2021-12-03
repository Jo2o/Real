package java.packt.Chapter11.P221_AtomicAction.src.modern.challenge;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIncrementator implements Runnable {

    public static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
