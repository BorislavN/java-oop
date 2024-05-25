package encapsulation.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppings) {
        this.setName(name);
        this.setToppings(toppings);
    }

    public String getName() {
        return this.name;
    }

    public void setDough(Dough dough) {
        Validator.validateNotNull(dough);

        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        Validator.validateNotNull(topping);
        Validator.validateNumberOfToppings(this.toppings.size() + 1);

        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        Validator.validateNotNull(this.dough);

        return this.dough.calculateCalories()
                + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
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
    }
}
