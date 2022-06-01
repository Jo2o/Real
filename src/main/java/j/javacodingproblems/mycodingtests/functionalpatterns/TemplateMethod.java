package j.javacodingproblems.mycodingtests.functionalpatterns;

import java.util.function.Consumer;

/**
 *  A skeleton of an algorithm in a method and defer certain steps of this algorithm to the client subclasses.
 */
public class TemplateMethod {

    public static void main(String[] args) {
        // traditional
        TemplateMethod templateMethod = new TemplateMethod();
        templateMethod.createGreekPizzaMaker().make(templateMethod.createPizza());
        System.out.println("---");
        templateMethod.createNapoliPizzaMaker().make(templateMethod.createPizza());
        System.out.println("-----------------------");

    // lambda
    new TemplateMethod()
        .createLambdaPizzaMaker()
        .make(
            templateMethod.createPizza(),                                         // this pizza is passed inside make()
            pizza -> System.out.println("...adding whatever you pass me here...") // pizza argument is passed inside the make()
        );
    }

    // LAMBDA
    
    public LambdaPizzaMaker createLambdaPizzaMaker() {
        return new LambdaPizzaMaker();
    }
    
    class LambdaPizzaMaker {
        public void make(Pizza pizza, Consumer<Pizza> addTopping) {
            makeDough(pizza);
            addTopping.accept(pizza);
            bake(pizza);
        }
        private void bake(Pizza pizza) {
            System.out.println("...baking...");
        }
        private void makeDough(Pizza pizza) {
            System.out.println("...making dough...");
        }
    }

    // TRADITIONAL
    
    public GreekPizzaMaker createGreekPizzaMaker() {
        return new GreekPizzaMaker();
    }

    public NapoliPizzaMaker createNapoliPizzaMaker() {
        return new NapoliPizzaMaker();
    }

    public Pizza createPizza() {
        return new Pizza();
    }

    abstract class PizzaMaker {
        public void make(Pizza pizza) {
            makeDough(pizza);
            addTopping(pizza);
            bake(pizza);
        }
        abstract void addTopping(Pizza pizza);
        
        private void bake(Pizza pizza) {
            System.out.println("...baking...");
        }
        private void makeDough(Pizza pizza) {
            System.out.println("...making dough...");
        }
    }

    class GreekPizzaMaker extends PizzaMaker {
        @Override
        public void addTopping(Pizza p) {
            System.out.println("...adding GREEK style toppings...");
        }
    }

    class NapoliPizzaMaker extends PizzaMaker {
        @Override
        public void addTopping(Pizza p) {
            System.out.println("...adding NAPOLI style toppings...");
        }
    }
    
    class Pizza {
    }
}
