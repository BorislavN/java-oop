package interfaces.six.implementations.factories;

import interfaces.six.enumerations.Corps;
import interfaces.six.enumerations.State;
import interfaces.six.implementations.CommandoImpl;
import interfaces.six.implementations.tasks.MissionImpl;
import interfaces.six.interfaces.Commando;
import interfaces.six.interfaces.Factory;
import interfaces.six.interfaces.Mission;
import interfaces.six.interfaces.Soldier;

public class CommandoFactory implements Factory {
    @Override
    public Soldier build(String[] args) {
        if (Corps.isValid(args[5])) {
            Commando newCommando = new CommandoImpl(
                    Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]), args[5]
            );

            for (int index = 6; index < args.length; index += 2) {
                String state = args[index + 1];

                if (State.isValid(state)) {
                    Mission mission = new MissionImpl(args[index], state);

                    newCommando.addMission(mission);
                }
            }

            return newCommando;
        }

        return null;
    }
}