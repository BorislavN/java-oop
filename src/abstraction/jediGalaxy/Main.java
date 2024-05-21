package abstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static boolean[][] galaxy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseCoordinates(scanner.nextLine());

        galaxy = new boolean[dimensions[0]][dimensions[1]];

        long collectedStars = 0;

        String input;

        while (!"Let the Force be with you".equals(input = scanner.nextLine())) {
            int[] jediLocation = parseCoordinates(input);
            int[] sithLocation = parseCoordinates(scanner.nextLine());

            travelTheGalaxy("sith", sithLocation[0], sithLocation[1]);

            collectedStars += travelTheGalaxy("jedi", jediLocation[0], jediLocation[1]);
        }

        System.out.println(collectedStars);
    }

    private static int travelTheGalaxy(String player, int x, int y) {
        boolean isJedi = "jedi".equals(player);
        boolean yIsValid = isJedi ? y < galaxy[0].length : y >= 0;

        int stars = 0;

        while (x >= 0 && yIsValid) {
            if (isOnTarget(x, y)) {
                if (isJedi && !galaxy[x][y]) {
                    stars += (x * galaxy[x].length + y);
                } else {
                    galaxy[x][y] = true;
                }
            }

            x--;
            y = isJedi ? y + 1 : y - 1;
        }

        return stars;
    }

    private static boolean isOnTarget(int x, int y) {
        return (x >= 0 && x < galaxy.length) && (y >= 0 && y < galaxy[x].length);
    }

    private static int[] parseCoordinates(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}