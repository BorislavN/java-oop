package encapsulation.pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public double calculateCalories() {
        return (2 * this.weight)
                * Helper.enumValue(ToppingType.class, this.toppingType).getModifier();
    }

    private void setToppingType(String toppingType) {
        Validator.checkToppingType(toppingType);

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(this.toppingType, weight);

        this.weight = weight;
    }
}
