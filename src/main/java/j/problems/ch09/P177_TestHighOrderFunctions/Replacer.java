package j.problems.ch09.P177_TestHighOrderFunctions;

@FunctionalInterface
public interface Replacer<String> {

    String replace(String s);
}
