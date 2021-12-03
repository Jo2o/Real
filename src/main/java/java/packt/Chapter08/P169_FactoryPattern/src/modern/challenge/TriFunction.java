package java.packt.Chapter08.P169_FactoryPattern.src.modern.challenge;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);
}
