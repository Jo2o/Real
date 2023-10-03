package j.problems.ch09lamb2.P177_TestHighOrderFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

    }

    @SuppressWarnings("unchecked")
    public static Function<String, String> reduceStrings(Function<String, String>... functions) {
        return Stream.of(functions).reduce(Function.identity(), Function::andThen);
    }

    public static List<String> replace(List<String> list, Replacer r) {
        if (list == null || r == null) {
            throw new IllegalArgumentException("List/replacer cannot be null");
        }
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(r.replace(s));
        }
        return result;
    }

}
