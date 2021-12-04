package j.packt.Chapter08.P172_ObserverPattern;

public interface FireStationRegister {
    
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);    
}
