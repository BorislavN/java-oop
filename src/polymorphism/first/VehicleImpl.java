package polymorphism.first;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private final DecimalFormat pattern;

    protected VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.pattern = new DecimalFormat("0.##");
    }

    @Override
    public String drive(double distance) {
        double requiredFuel = distance * this.fuelConsumption;

        if (requiredFuel <= this.fuelQuantity) {
            this.fuelQuantity -= requiredFuel;

            return String.format("%s travelled %s km", this.getClass().getSimpleName(), this.pattern.format(distance));
        }

        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

    @Override
    public void refuel(double amount) {
        this.fuelQuantity += amount;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
