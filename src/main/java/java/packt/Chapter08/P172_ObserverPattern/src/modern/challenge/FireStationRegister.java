package java.packt.Chapter08.P172_ObserverPattern.src.modern.challenge;

public interface FireStationRegister {
    
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);    
}
