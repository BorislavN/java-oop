package encapsulation.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        for (int line = 0; line < 2; line++) {
            String[] data = reader.readLine().split(";");

            for (String entry : data) {
                String[] parts = entry.split("=");
                int value = Integer.parseInt(parts[1]);

                try {
                    VoidFunction function = () -> people.put(parts[0], new Person(parts[0], value));

                    if (line == 1) {
                        function = () -> products.put(parts[0], new Product(parts[0], value));
                    }

                    performInTryCatch(function);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] data = input.split("\\s");

            Person person = people.get(data[0]);
            Product product = products.get(data[1]);

            if (person != null && product != null) {
                performInTryCatch(() -> person.buyProduct(product));
            }
        }

        people.values().forEach(System.out::println);
    }

    private static void performInTryCatch(VoidFunction function) {
        try {
            function.apply();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
