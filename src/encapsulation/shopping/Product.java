package encapsulation.shopping;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private void setName(String name) {
        Validator.validateName(name);

        this.name = name;
    }

    private void setCost(double cost) {
        Validator.validateDouble("Cost", cost);

        this.cost = cost;
    }
}
