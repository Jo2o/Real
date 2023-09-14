package designpatterns.singleton;

public class MainThreadSafeDoubleChecked {

    public static void main(String[] args){
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        // this goes wrong since threads create singletons at the same time - they are unaware of INSTANCE being created by both threads!
        thread1.start();
        thread2.start();
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            SingletonLazyThreadSafe singletonNaive1Thread = SingletonLazyThreadSafe.getInstance("S-1");
            System.out.println(singletonNaive1Thread.value);
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            SingletonLazyThreadSafe singletonNaive1Thread = SingletonLazyThreadSafe.getInstance("S-2");
            System.out.println(singletonNaive1Thread.value);
        }
    }
}
