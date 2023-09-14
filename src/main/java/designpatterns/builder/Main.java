package designpatterns.builder;

public class Main {

    public static void main(String[] args){
        CarLombok
            .builder()        // returns inner static class CarLombokBuilder
            .color("red")     // color = color | return this;
            .maxSpeed(200)
            .build();         // return new CarLombok(this.,this.,this.,this.)

        new Car.CarBuilder("Toyota", "diesel")
            .color("red")
            .maxSpeed(150)
            .build();
    }
}
