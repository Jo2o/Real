package j.initializationblocks;

public class Main {

    public static void main(String[] args) {
        System.out.println(">>> Creating Volvo");
        Car volvo = new Car("volvo");
        System.out.println(">>> Created Volvo");
        System.out.println("---------------------");
        System.out.println(">>> Creating Mercedes");
        Car mercedes = new Car("mercedes");
        System.out.println(">>> Created Mercedes");
    }
}
