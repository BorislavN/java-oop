package polymorphism.first;

public class Truck extends VehicleImpl {
    private static final double TRUCK_CONSUMPTION_MODIFIER = 1.6;
    private static final double TRUCK_REFUEL_MODIFIER = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * TRUCK_REFUEL_MODIFIER);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + TRUCK_CONSUMPTION_MODIFIER);
    }
}
