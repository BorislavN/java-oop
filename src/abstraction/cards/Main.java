package abstraction.cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        switch (command) {
            case "Card Suits":
                System.out.println("Card Suits:");
                printValues(Suits.values());
                break;
            case "Card Ranks":
                System.out.println("Card Ranks:");
                printValues(Ranks.values());
                break;
            default:
                String suitName = reader.readLine();

                Ranks rank = Ranks.valueOf(command);
                Suits suit = Suits.valueOf(suitName);

                System.out.printf("Card name: %s of %s; Card power: %d%n", rank, suit, rank.getPower() + suit.getPower());
                break;
        }
    }

    private static <T extends Enum<T>> void printValues(Enum<T>[] values) {
        Arrays.stream(values).forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s%n"
                , e.ordinal(), e.name())
        );
    }
}
