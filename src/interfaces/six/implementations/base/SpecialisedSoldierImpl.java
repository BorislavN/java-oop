package interfaces.six.implementations.base;

import interfaces.six.enumerations.Corps;
import interfaces.six.implementations.PrivateImpl;
import interfaces.six.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    public void setCorps(String corps) {
        this.corps = Corps.valueOf(corps.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.corps.getName());
    }
}
