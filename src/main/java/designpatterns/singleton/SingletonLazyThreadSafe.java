package designpatterns.singleton;

/* Double-checked locking - prevents race condition between multiple threads. */

public class SingletonLazyThreadSafe {
    private static volatile SingletonLazyThreadSafe INSTANCE; // volatile is important

    public String value;

    private SingletonLazyThreadSafe(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.value = value;
    }

    public static SingletonLazyThreadSafe getInstance(String value) {
        SingletonLazyThreadSafe result = INSTANCE;   // this is not redundant!
        if (result != null) {
            return result;
        }
        synchronized (SingletonLazyThreadSafe.class) {
            if (INSTANCE == null) {
                INSTANCE = new SingletonLazyThreadSafe(value);
            }
            return INSTANCE;
        }
    }
}
