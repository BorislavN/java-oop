package polymorphism.second;

public class Car extends VehicleImpl {
    private static final double CAR_CONSUMPTION_MODIFIER = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity,CAR_CONSUMPTION_MODIFIER);
    }
}
