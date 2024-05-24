package encapsulation.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int capacity;

    public Pizza(String name, int toppings) {
        this.setName(name);
        this.setToppings(toppings);
    }


    public String getName() {
        return this.name;
    }

    public void setDough(Dough dough) {
        if (dough != null) {
            this.dough = dough;
        }
    }

    public boolean hasDough() {
        return this.dough != null;
    }


    public void addTopping(Topping topping) {
        if (topping != null && this.toppings.size() < this.capacity) {
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        double doughCal = this.hasDough() ? this.dough.calculateCalories() : 0;

        return doughCal + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }


    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);

        this.name = name;
    }

    private void setToppings(int count) {
        Validator.validateNumberOfToppings(count);

        this.toppings = new ArrayList<>();
        this.capacity = count;
    }
}
