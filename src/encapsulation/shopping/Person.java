package encapsulation.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String productList = this.products.stream().map(Objects::toString).collect(Collectors.joining(" "));

        return String.format("%s - %s"
                , this.name
                , this.products.isEmpty() ? "Nothing bought" : productList
        );
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }

        this.products.add(product);
        this.money -= product.getCost();
    }

    private void setName(String name) {
        Validator.validateName(name);

        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateDouble("Money", money);

        this.money = money;
    }
}
