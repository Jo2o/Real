package designpatterns.factorymethod;

public class DomesticPlan extends Plan {
    @Override
    void setupRate() {
        setRate(3.5);
    }
}
