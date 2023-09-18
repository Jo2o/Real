package initializationblocks;

public class Car {

    private static final String CONSTANT = "default constant";
    private static String STAT = "inline stat definition";
    private String field = "inline field definition";

    static {
        System.out.println("static block...");
        STAT = "static";
    }

    {
        System.out.println("instance block");
        field = "field";
    }

    public Car(String str) {
        System.out.println("constructor...");
        field = str;
    }

}
