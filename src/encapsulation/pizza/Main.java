package encapsulation.pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaData = reader.readLine().split("\\s+");
            String[] doughData = reader.readLine().split("\\s+");

            Pizza pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
            Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));

            pizza.setDough(dough);

            String input;

            while (!"END".equals(input = reader.readLine())) {
                String[] toppingData = input.split("\\s+");

                pizza.addTopping(new Topping(toppingData[1], Double.parseDouble(toppingData[2])));
            }

            if (pizza.hasDough()) {
                System.out.println(pizza);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}