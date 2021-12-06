package j.packt.Chapter08.P166_WritingFunctionalInterfaces;

@FunctionalInterface
public interface Predicate<T> {
    
    boolean test(T t);
}