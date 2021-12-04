package j.packt.Chapter08.P166_WritingFunctionalInterfaces;

public class HugeMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {                       
        return melon.getWeight() > 5000;
    }
    
}
