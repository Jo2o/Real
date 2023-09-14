package designpatterns.builder;

public class Car {

    // required
    private String brand;
    private String fuelType;

    // optional
    private int maxSpeed;
    private String color;

    public Car(CarBuilder carBuilder) {
        this.brand = carBuilder.brand;
        this.fuelType = carBuilder.fuelType;
        this.maxSpeed = carBuilder.maxSpeed;
        this.color = carBuilder.color;
    }

    public static class CarBuilder {
        // required
        private String brand;
        private String fuelType;

        // optional
        private int maxSpeed;
        private String color;

        public CarBuilder(String brand, String fuelType) {
            this.brand = brand;
            this.fuelType = fuelType;
        }

        public CarBuilder maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public  Car build() {
            return new Car(this);
        }
    }
}
