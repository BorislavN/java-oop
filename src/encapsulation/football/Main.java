package encapsulation.football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] data = input.split(";");

            try {
                String team = data[1];
                String invalidTeamError = String.format("Team %s does not exist.", team);
                SimplePredicate teamPredicate = () -> teams.containsKey(team);

                switch (data[0]) {
                    case "Team":
                        teams.putIfAbsent(team, new Team(team));

                        break;

                    case "Add":
                        String name = data[2];

                        int endurance = Integer.parseInt(data[3]);
                        int sprint = Integer.parseInt(data[4]);
                        int dribble = Integer.parseInt(data[5]);
                        int passing = Integer.parseInt(data[6]);
                        int shooting = Integer.parseInt(data[7]);

                        Validator.testCondition(invalidTeamError, teamPredicate);

                        Player player = new Player(name, endurance, sprint, dribble, passing, shooting);

                        teams.get(team).addPlayer(player);

                        break;

                    case "Remove":
                        String playerName = data[2];

                        Validator.testCondition(invalidTeamError, teamPredicate);

                        teams.get(team).removePlayer(playerName);

                        break;

                    case "Rating":
                        Validator.testCondition(invalidTeamError, teamPredicate);

                        System.out.println(teams.get(team));

                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
