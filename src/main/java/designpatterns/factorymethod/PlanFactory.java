package designpatterns.factorymethod;

public class PlanFactory {

    public static final String DOMESTIC = "domestic";
    public static final String COMMERCIAL = "commercial";

    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }
        switch (planType) {
            case DOMESTIC:
                return new DomesticPlan();
            case COMMERCIAL:
                return new CommercialPlan();
            default:
                return null;
        }
    }
}
