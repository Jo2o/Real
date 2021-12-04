package j.packt.Chapter08.P171_TemplateMethodPattern;

public class GreekPizza extends PizzaMaker {

    @Override
    public void addTopIngredients(Pizza p) {
        System.out.println("Add:  sauce and cheese");
    }

}
