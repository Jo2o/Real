package j.javacodingproblems.Chapter11.P224_StampedLock_tryConvertToWriteLock;

public class Main {

    public static void main(String[] args) {

        ConvertToWriteLock convertToWriteLock = new ConvertToWriteLock();
        convertToWriteLock.withdraw(500);
    }
}
