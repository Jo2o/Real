package j.javacodingproblems.Chapter09.P177_TestHighOrderFunctions;

@FunctionalInterface
public interface Replacer<String> {

    String replace(String s);
}
