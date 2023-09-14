package designpatterns.singleton;

public class SingletonLazyNoThreadSafe {
    private static SingletonLazyNoThreadSafe INSTANCE;

    public String value;

    private SingletonLazyNoThreadSafe(String value) {
        // slow initialization emulation - i.e., second thread cannot see other singleton being created
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.value = value;
    }

    public static SingletonLazyNoThreadSafe getInstance(String value) {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLazyNoThreadSafe(value);
        }
        return INSTANCE;
    }
}
