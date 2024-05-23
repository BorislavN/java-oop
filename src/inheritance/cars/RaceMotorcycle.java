package inheritance.cars;

public class RaceMotorcycle extends Motorcycle{
    private static final double DEFAULT_FUEL_CONSUMPTION = 8;
    public RaceMotorcycle(double fuel, int horsepower) {
        super(fuel, horsepower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
