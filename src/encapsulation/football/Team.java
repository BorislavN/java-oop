package encapsulation.football;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        Validator.validateNotNull(player);

        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean removed = this.players.removeIf(p -> p.getName().equals(name));

        String error = String.format("Player %s is not in %s team.", name, this.name);

        Validator.testCondition(error, () -> removed);
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, Math.round(this.getRating()));
    }

    private void setName(String name) {
        Validator.validateName(name);

        this.name = name;
    }
}
