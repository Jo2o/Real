package functional.mine;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceTest {

    public static void main(String[] args) {
        List<Banana> bananas = List.of(
            Banana.builder().size("1").build(),
            Banana.builder().size("2").build(),
            Banana.builder().size("3").build());
        System.out.println("3 BANANAS:\n--------------------");
        System.out.println(
            bananas.stream()
                .map(Banana::getSize)
                .reduce(ReduceTest::mergeSizes)
                .orElse("!nothing!"));

        System.out.println();

        List<Banana> singleBananaList =  List.of(Banana.builder().size("SINGLE").build());

        System.out.println("SINGLE BANANA:\n--------------------");
        System.out.println(
            singleBananaList.stream()
                .map(Banana::getSize)
                .reduce(ReduceTest::mergeSizes)
                .orElse("!nothing!"));
    }

    private static String mergeSizes(String str1, String str2) {
        System.out.println(">>>>>> mergeSizes() invoked <<<<<<<<");
        return str1 + "-" + str2;
    }

//    private static BinaryOperator<String> mergeSizes() {
//        System.out.println(">>>>>> mergeSizes() invoked <<<<<<<<");
//        return (b1Size, b2Size) -> b1Size + "-" + b2Size;
//    }

}
