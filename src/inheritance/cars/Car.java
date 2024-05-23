package inheritance.cars;

public class Car extends Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsepower) {
        super(fuel, horsepower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
