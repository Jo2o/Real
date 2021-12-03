package java.packt.Chapter08.P171_TemplateMethodPattern.src.modern.challenge;

public class NeapolitanPizza extends PizzaMaker {

    @Override
    public void addTopIngredients(Pizza p) {
        System.out.println("Add: fresh mozzarella, tomatoes, basil leaves, oregano, and olive oil");
    }
    
}
