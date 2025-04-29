import java.util.*;

interface CarFeature {
    String name();
    String details();
}

interface AddOn {
    String addOn();
}

class Sunroof implements AddOn {
    @Override
    public String addOn() {
        return "Sunroof";
    }
}

class InfotainmentSystem implements AddOn {
    @Override
    public String addOn() {
        return "Infotainment System";
    }
}

abstract class Base implements CarFeature {
    @Override
    public abstract String details();
}

class ModelName extends Base {
    private final String modelName;

    public ModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String name() {
        return "Model Name";
    }

    @Override
    public String details() {
        return modelName;
    }
}

class Engine extends Base {
    private final String Engine;

    public Engine(String Engine) {
        this.Engine = Engine;
    }

    @Override
    public String name() {
        return "Engine Type";
    }

    @Override
    public String details() {
        return Engine;
    }
}

class Color extends Base {
    private final String color;

    public Color(String color) {
        this.color = color;
    }

    @Override
    public String name() {
        return "Color";
    }

    @Override
    public String details() {
        return color;
    }
}

class Transmission extends Base {
    private final String transmission;

    public Transmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String name() {
        return "Transmission";
    }

    @Override
    public String details() {
        return transmission;
    }
}

class Car {
    private final List<CarFeature> features = new ArrayList<>();
    private final List<AddOn> addOns = new ArrayList<>();

    public void addFeature(CarFeature feature) {
        features.add(feature);
    }

    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
    }

    public void showConfiguration() {
        System.out.println("Car Configuration:");
        for (CarFeature feature : features) {
            System.out.println(feature.name() + ": " + feature.details());
        }
        for (AddOn addOn : addOns) {
            System.out.println("Add-On: " + addOn.addOn());
        }
    }
}

class CarBuilder {
    public Car buildDefaultCar() {
        Car car = new Car();
        car.addFeature(new ModelName("Default Model"));
        car.addFeature(new Engine("Petrol"));
        car.addFeature(new Color("White"));
        car.addFeature(new Transmission("Manual"));
        return car;
    }

    public Car buildCustomizedCar() {
        Car car = new Car();
        car.addFeature(new ModelName("Tesla Model 3"));
        car.addFeature(new Engine("Electric"));
        car.addFeature(new Color("Midnight Silver"));
        car.addFeature(new Transmission("Automatic"));
        car.addAddOn(new Sunroof());
        car.addAddOn(new InfotainmentSystem());
        return car;
    }
}

public class CarBuilderPattern {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
       
        Car defaultCar = carBuilder.buildDefaultCar();
        System.out.println("Default Car:");
        defaultCar.showConfiguration();

        System.out.println("\nCustomized Car:");
        Car customizedCar = carBuilder.buildCustomizedCar();
        customizedCar.showConfiguration();
    }
}
