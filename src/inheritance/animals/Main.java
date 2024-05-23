package inheritance.animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(input = reader.readLine())) {
            String[] data = reader.readLine().split("\\s+");
            int age = Integer.parseInt(data[1]);

            Animal animal = null;

            try {
                switch (input) {
                    case "Cat":
                        animal = new Cat(data[0], age, data[2]);

                        break;

                    case "Dog":
                        animal = new Dog(data[0], age, data[2]);

                        break;

                    case "Frog":
                        animal = new Frog(data[0], age, data[2]);

                        break;

                    case "Tomcat":
                        animal = new Tomcat(data[0], age);

                        break;

                    case "Kitten":
                        animal = new Kitten(data[0], age);

                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (animal != null) {
                animals.add(animal);
            }
        }

        animals.forEach(System.out::println);
    }
}
