package java.packt.Chapter08.P166_WritingFunctionalInterfaces.src.modern.challenge;

public class HugeMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {                       
        return melon.getWeight() > 5000;
    }
    
}
