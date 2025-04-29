class Car {
    private String modelName;
    private String engineType;
    private String color;
    private String transmission;
    private boolean sunroof;
    private boolean infotainmentSystem;

    // Private constructor to enforce Builder use
    private Car(CarBuilder builder) {
        this.modelName = builder.modelName;
        this.engineType = builder.engineType;
        this.color = builder.color;
        this.transmission = builder.transmission;
        this.sunroof = builder.sunroof;
        this.infotainmentSystem = builder.infotainmentSystem;
    }

    @Override
    public String toString() {
        return "Model Name: " + modelName + "\n"
             + "Engine Type: " + engineType + "\n"
             + "Color: " + color + "\n"
             + "Transmission: " + transmission + "\n"
             + "Sunroof: " + (sunroof ? "Yes" : "No") + "\n"
             + "Infotainment System: " + (infotainmentSystem ? "Yes" : "No") + "\n";
    }

    public static class CarBuilder {
        // Default values for Default Car
        private String modelName = "Default Model";
        private String engineType = "Petrol";
        private String color = "White";
        private String transmission = "Manual";
        private boolean sunroof = false;
        private boolean infotainmentSystem = false;

        public CarBuilder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setTransmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setInfotainmentSystem(boolean infotainmentSystem) {
            this.infotainmentSystem = infotainmentSystem;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

public class BuilderCarCustomization {
    public static void main(String[] args) {
        Car defaultCar = new Car.CarBuilder().build();
        System.out.println("Default Car Configuration:\n" + defaultCar);

        Car customCar = new Car.CarBuilder()
            .setModelName("Tesla Model 3")
            .setEngineType("Electric")
            .setColor("Midnight Silver")
            .setTransmission("Automatic")
            .setSunroof(true)
            .setInfotainmentSystem(true)
            .build();

        System.out.println("Customized Car Configuration:\n" + customCar);
    }
}
