package encapsulation.box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        try {
            System.out.println(new Box(length, width, height));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}