package j.problems.ch08.P172_ObserverPattern;

public interface FireStationRegister {

    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);
}
