package j.packt.Chapter07.P155_CheckDefaultMethods.src.modern.challenge;

public interface Slicer {

    public void type();

    default void slice() {
        System.out.println("slice");
    }
}
