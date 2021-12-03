package java.packt.Chapter10.P200_ObjectVsClassLevelLocking.src.modern.challenge;

public class TwoCll {

    public synchronized static void staticMethod1() {
        System.out.println("staticMethod1(): " + Thread.currentThread().getName());
        while (true) {
        }
    }
    
    public synchronized static void staticMethod2() {
        System.out.println("staticMethod2(): " + Thread.currentThread().getName());
        while (true) {
        }
    }
}
