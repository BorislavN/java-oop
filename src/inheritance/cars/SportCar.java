package inheritance.cars;

public class SportCar extends Car {
    private static final double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsepower) {
        super(fuel, horsepower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
