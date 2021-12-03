package java.packt.Chapter08.P166_WritingFunctionalInterfaces.src.modern.challenge;

@FunctionalInterface
public interface Predicate<T> {
    
    boolean test(T t);
}
