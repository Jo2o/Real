package j.packt.Chapter09.P177_TestHighOrderFunctions;

@FunctionalInterface
public interface Replacer<String> {
    
    String replace(String s);
}
