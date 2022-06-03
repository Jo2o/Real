package j.problems.mycodingtests.functionalpatterns;

import java.util.function.UnaryOperator;
import lombok.experimental.UtilityClass;

/**
 *  A skeleton of an algorithm in a method and defer certain steps of this algorithm to the client subclasses.
 */
public class Strategy {

    public static void main(String[] args) {
        // lambda
        String noNumber = Remover.remove("This is a text from 20 April 2050", s -> s.replaceAll("\\d", ""));
        String noSpace = Remover.remove("This is a text from 20 April 2050", s -> s.replaceAll("\\s", ""));
        System.out.println(noNumber);
        System.out.println(noSpace);
        
        // No need for whole classes implementing interface RemoveStrategy such as NumberRemover implements RemoveStrategy | WhitespacesRemover implements RemoveStrategy
        // String noNr = Remover.remove(text, new NumberRemover()); we can pass the behavior directly
    }

// LAMBDA
//    @FunctionalInterface
//    interface RemoveStrategy {
//        String remove(String str);
//    }
    
    @UtilityClass
    final class Remover {
        public static String remove(String str, UnaryOperator<String> operator) {
            return operator.apply(str);
        }
    }
}
