package polymorphism.second;

public class Bus extends VehicleImpl {
    private static final double BUS_CONSUMPTION_MODIFIER = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, BUS_CONSUMPTION_MODIFIER);
    }
}
