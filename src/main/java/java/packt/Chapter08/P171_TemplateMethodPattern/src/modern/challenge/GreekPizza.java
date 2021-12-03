package java.packt.Chapter08.P171_TemplateMethodPattern.src.modern.challenge;

public class GreekPizza extends PizzaMaker {

    @Override
    public void addTopIngredients(Pizza p) {
        System.out.println("Add:  sauce and cheese");
    }

}
