package j.packt.Chapter04.P98_VarWildcardsCovariantsContravariants;

public class Main {

    public static void main(String[] args) {            
        
        // explicit type
        Class<?> clazz = Long.class;

        // use var
        var clazzLong = Long.class;
    }

}