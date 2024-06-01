package polymorphism.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] carData = parseData(reader.readLine());
        double[] truckData = parseData(reader.readLine());

        Vehicle car = new Car(carData[0], carData[1]);
        Vehicle truck = new Truck(truckData[0], truckData[1]);

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            double value=Double.parseDouble(data[2]);

            Vehicle current = "Car".equals(data[1]) ? car : truck;

            switch (data[0]){
                case "Drive": System.out.println(current.drive(value));break;
                case "Refuel":current.refuel(value);break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static double[] parseData(String input) {
        return Arrays.stream(input.split("\\s+")).skip(1).mapToDouble(Double::parseDouble).toArray();
    }
}
