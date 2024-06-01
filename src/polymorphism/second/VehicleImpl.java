package polymorphism.second;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private final double fuelConsumption;
    private final double tankCapacity;
    private final double airConditionerModifier;
    private boolean hasAirConditioning;
    private final DecimalFormat pattern;

    protected VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity, double airConditionerModifier) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.airConditionerModifier = airConditionerModifier;
        this.hasAirConditioning = true;
        this.pattern = new DecimalFormat("0.##");
    }

    @Override
    public String drive(double distance) {
        double currentRate = this.fuelConsumption;

        if (this.hasAirConditioning) {
            currentRate += this.airConditionerModifier;
        }

        double requiredFuel = distance * currentRate;

        if (requiredFuel <= this.fuelQuantity) {
            this.fuelQuantity -= requiredFuel;

            return String.format("%s travelled %s km", this.getClass().getSimpleName(), this.pattern.format(distance));
        }

        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

    @Override
    public void refuel(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + amount > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += amount;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    @Override
    public void setAirConditioner(boolean state) {
        this.hasAirConditioning = state;
    }
}