package interfaces.six.implementations.factories;

import interfaces.six.enumerations.Corps;
import interfaces.six.implementations.EngineerImpl;
import interfaces.six.implementations.tasks.RepairImpl;
import interfaces.six.interfaces.Engineer;
import interfaces.six.interfaces.Factory;
import interfaces.six.interfaces.Repair;
import interfaces.six.interfaces.Soldier;

public class EngineerFactory implements Factory {
    @Override
    public Soldier build(String[] args) {
        if (Corps.isValid(args[5])) {
            Engineer newEngineer = new EngineerImpl(
                    Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4]), args[5]
            );

            for (int index = 6; index < args.length; index += 2) {
                Repair repair = new RepairImpl(args[index], Integer.parseInt(args[index + 1]));

                newEngineer.addRepair(repair);
            }

            return newEngineer;
        }

        return null;
    }
}
