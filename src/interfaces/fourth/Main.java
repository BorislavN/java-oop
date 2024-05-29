package interfaces.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        Map<String, Buyer> buyers = new HashMap<>();

        while (lines-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            int age = Integer.parseInt(data[1]);

            switch (data.length) {
                case 3:
                    buyers.putIfAbsent(data[0], new Rebel(data[0], age, data[2]));

                    break;

                case 4:
                    buyers.putIfAbsent(data[0], new Citizen(data[0], age, data[2], data[3]));

                    break;
            }
        }

        String input;

        while (!"End".equals(input=reader.readLine())){
            Buyer current=buyers.get(input);

            if (current!=null){
                current.buyFood();
            }
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
