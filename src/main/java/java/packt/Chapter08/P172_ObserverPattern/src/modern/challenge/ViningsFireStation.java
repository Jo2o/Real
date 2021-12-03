package java.packt.Chapter08.P172_ObserverPattern.src.modern.challenge;

public class ViningsFireStation implements FireObserver {

    @Override
    public void fire(String address) {        
        if(address.contains("Vinings")) {
            System.out.println("Vinings fire station will go to this fire");
        }
    }
    
}
