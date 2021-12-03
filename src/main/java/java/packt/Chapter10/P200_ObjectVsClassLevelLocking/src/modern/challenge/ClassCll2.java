package java.packt.Chapter10.P200_ObjectVsClassLevelLocking.src.modern.challenge;

public class ClassCll2 {

    public void method() {
        synchronized (ClassCll2.class) {
            System.out.println("This is an CLL example");
        }
    }
}
