package j.problems.ch08lamb1.P172_ObserverPattern;

public interface FireStationRegister {

    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);
}
