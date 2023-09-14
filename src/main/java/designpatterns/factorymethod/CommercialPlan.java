package designpatterns.factorymethod;

public class CommercialPlan extends Plan {
    @Override
    void setupRate() {
        setRate(7.3);
    }
}
