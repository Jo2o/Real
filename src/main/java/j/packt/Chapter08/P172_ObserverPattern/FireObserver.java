package j.packt.Chapter08.P172_ObserverPattern;

@FunctionalInterface
public interface FireObserver {

    void fire(String address);
}
