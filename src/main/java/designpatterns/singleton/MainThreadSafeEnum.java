package designpatterns.singleton;

public class MainThreadSafeEnum {

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
            SingletonEagerEnum.INSTANCE.doSomething();
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            SingletonEagerEnum.INSTANCE.doSomething();
        }
    }
}
