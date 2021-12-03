package java.packt.Chapter11.P221_AtomicAction.src.modern.challenge;

public class Incrementator implements Runnable {

    public static int count = 0;
    
    @Override
    public void run() {
        count ++;
    }

    public int getCount() {
        return count;
    }        
}
