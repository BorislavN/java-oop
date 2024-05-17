package abstraction.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLight[] lights = Arrays.stream(reader.readLine().split("\\s+"))
                .map(TrafficLight::valueOf).toArray(TrafficLight[]::new);


        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            printCycle(lights);
        }
    }

    private static void printCycle(TrafficLight[] lights) {
        StringBuilder output = new StringBuilder();

        TrafficLight[] values = TrafficLight.values();

        for (int i = 0; i < lights.length; i++) {
            lights[i] = values[(lights[i].ordinal() + 1) % values.length];

            output.append(lights[i]).append(" ");
        }

        System.out.println(output);
    }
}
