package polymorphism.first;

public class Car extends VehicleImpl {
    private static final double CAR_CONSUMPTION_MODIFIER = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CAR_CONSUMPTION_MODIFIER);
    }
}
