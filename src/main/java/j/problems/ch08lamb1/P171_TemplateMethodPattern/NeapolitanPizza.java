package j.problems.ch08lamb1.P171_TemplateMethodPattern;

public class NeapolitanPizza extends PizzaMaker {

    @Override
    public void addTopIngredients(Pizza p) {
        System.out.println("Add: fresh mozzarella, tomatoes, basil leaves, oregano, and olive oil");
    }

}
