package polymorphism.second;

public class Truck extends VehicleImpl {
    private static final double TRUCK_CONSUMPTION_MODIFIER = 1.6;
    private static final double TRUCK_REFUEL_MODIFIER = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, TRUCK_CONSUMPTION_MODIFIER);
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * TRUCK_REFUEL_MODIFIER);
    }
}
