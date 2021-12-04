package j.packt.Chapter10.P200_ObjectVsClassLevelLocking;

public class ClassCll1 {

    public synchronized static void methodCll() {
        System.out.println("This is an CLL example");
    }
}
