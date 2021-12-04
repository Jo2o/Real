package j.packt.Chapter11.P224_StampedLock_tryConvertToWriteLock;

public class Main {
    
    public static void main(String[] args) {
        
        ConvertToWriteLock convertToWriteLock = new ConvertToWriteLock();
        convertToWriteLock.withdraw(500);
    }   
}
