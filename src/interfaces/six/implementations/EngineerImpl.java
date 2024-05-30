package interfaces.six.implementations;

import interfaces.six.interfaces.Engineer;
import interfaces.six.interfaces.Repair;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    protected final Set<Repair> repairs;

    protected EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString()).append(System.lineSeparator());
        output.append("Repairs:").append(System.lineSeparator());

        this.repairs.forEach(r -> output.append(r).append(System.lineSeparator()));

        return output.toString().trim();
    }
}
