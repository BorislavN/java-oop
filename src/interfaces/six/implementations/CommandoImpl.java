package interfaces.six.implementations;

import interfaces.six.implementations.base.SpecialisedSoldierImpl;
import interfaces.six.interfaces.Commando;
import interfaces.six.interfaces.Mission;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private final Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString()).append(System.lineSeparator());
        output.append("Missions:").append(System.lineSeparator());

        this.missions.forEach(m -> output.append(m).append(System.lineSeparator()));

        return output.toString().trim();
    }
}
