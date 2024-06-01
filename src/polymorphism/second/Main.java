package polymorphism.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] carData = parseData(reader.readLine());
        double[] truckData = parseData(reader.readLine());
        double[] busData = parseData(reader.readLine());


        Vehicle car = new Car(carData[0], carData[1], carData[2]);
        Vehicle truck = new Truck(truckData[0], truckData[1], truckData[2]);
        Vehicle bus = new Bus(busData[0], busData[1], busData[2]);

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            double value = Double.parseDouble(data[2]);

            Vehicle current;

            switch (data[1]) {
                case "Car":
                    current = car;
                    break;
                case "Truck":
                    current = truck;
                    break;
                case "Bus":
                    current = bus;
                    break;
                default:
                    continue;
            }

            switch (data[0]) {
                case "Drive":
                    if ("Bus".equals(data[1])) {
                        current.setAirConditioner(true);
                    }

                    System.out.println(current.drive(value));

                    break;

                case "DriveEmpty":
                    if ("Bus".equals(data[1])) {
                        current.setAirConditioner(false);
                        System.out.println(current.drive(value));
                    }

                    break;

                case "Refuel":
                    try {
                        current.refuel(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    public static double[] parseData(String input) {
        return Arrays.stream(input.split("\\s+")).skip(1).mapToDouble(Double::parseDouble).toArray();
    }
}