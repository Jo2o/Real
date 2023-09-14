package designpatterns.factorymethod;

public abstract class Plan {
    private double rate;

    abstract void setupRate();

    public void setRate(double rate) {
        this.rate = rate;
    }
    public void calculateBill(int units) {
        System.out.println(units * rate);
    }
}
