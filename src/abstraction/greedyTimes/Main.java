
package abstraction.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());

        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            int amount = Integer.parseInt(safe[i + 1]);

            bag.addItem(name, amount);
        }

        System.out.println(bag);
    }
}