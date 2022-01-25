package j.javacodingproblems.Chapter08.P166_WritingFunctionalInterfaces;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);
}
