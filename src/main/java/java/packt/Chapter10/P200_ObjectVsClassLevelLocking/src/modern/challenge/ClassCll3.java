package java.packt.Chapter10.P200_ObjectVsClassLevelLocking.src.modern.challenge;

public class ClassCll3 {

    private final static Object aLock = new Object();
  
    public void method() {
        synchronized (aLock) {
            System.out.println("This is an CLL example");
        }
    }
}
