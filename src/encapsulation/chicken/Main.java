package encapsulation.chicken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            System.out.println(new Chicken(name, age));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
