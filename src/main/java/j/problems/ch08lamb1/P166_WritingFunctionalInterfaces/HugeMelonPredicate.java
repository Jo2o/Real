package j.problems.ch08lamb1.P166_WritingFunctionalInterfaces;

public class HugeMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {
        return melon.getWeight() > 5000;
    }

}
