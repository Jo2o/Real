package j.problems.ch08lamb1.P166_WritingFunctionalInterfaces;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);
}
