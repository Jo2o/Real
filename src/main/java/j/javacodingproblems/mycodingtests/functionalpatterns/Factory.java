package j.javacodingproblems.mycodingtests.functionalpatterns;

import j.javacodingproblems.Chapter08.P169_FactoryPattern.Cantaloupe;
import j.javacodingproblems.Chapter08.P169_FactoryPattern.Fruit;
import j.javacodingproblems.Chapter08.P169_FactoryPattern.Gac;
import j.javacodingproblems.Chapter08.P169_FactoryPattern.Hemi;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 *  A skeleton of an algorithm in a method and defer certain steps of this algorithm to the client subclasses.
 */
public class Factory {

    private static final Map<String, Supplier<Fruit>> MELONS = Map.of("Gac", Gac::new, "Hemi", Hemi::new, "Cantaloupe", Cantaloupe::new);
    
    public static void main(String[] args) {
        System.out.println(Factory.newInstance(Hemi.class));
    }

    public static Fruit newInstance(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        return MELONS.get(clazz.getSimpleName()).get();
    }
}
