package interfaces.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> list = new ArrayList<>();

        String input;

        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "Citizen":
                    int age = Integer.parseInt(data[2]);
                    list.add(new Citizen(data[1], age, data[3], data[4]));
                    break;
                case "Pet":
                    list.add(new Pet(data[1], data[2]));
                    break;
            }
        }

        String filter = reader.readLine();

        list.stream().filter(b -> b.getBirthDate().endsWith(filter)).forEach(e -> System.out.println(e.getBirthDate()));
    }
}
