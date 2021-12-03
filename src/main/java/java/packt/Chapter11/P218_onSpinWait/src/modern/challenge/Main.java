package java.packt.Chapter11.P218_onSpinWait.src.modern.challenge;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        StartService startService = new StartService();
        
        new Thread(startService).start();
        
        Thread.sleep(5000);
        
        startService.setServiceAvailable(true);
    }
    
}
