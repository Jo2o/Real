package designpatterns.builder;

public class CarLombok {
    // required
    private String brand;
    private String fuelType;
    // optional
    private int maxSpeed;
    private String color;

    CarLombok(String brand, String fuelType, int maxSpeed, String color) {
        this.brand = brand;
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public static CarLomboksBuilder builder() {
        return new CarLomboksBuilder();
    }

    public static class CarLomboksBuilder {
        private String brand;
        private String fuelType;
        private int maxSpeed;
        private String color;

        CarLomboksBuilder() {}

        public CarLomboksBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }
        public CarLomboksBuilder fuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }
        public CarLomboksBuilder maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }
        public CarLomboksBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarLombok build() {
            return new CarLombok(this.brand, this.fuelType, this.maxSpeed, this.color);
        }
    }
}
