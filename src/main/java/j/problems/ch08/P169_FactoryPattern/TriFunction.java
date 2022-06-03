package j.problems.ch08.P169_FactoryPattern;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);
}
