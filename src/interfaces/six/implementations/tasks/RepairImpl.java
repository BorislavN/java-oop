package interfaces.six.implementations.tasks;

import interfaces.six.interfaces.Repair;

public class RepairImpl implements Repair{
    private final String partName;
    private final int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairImpl repair = (RepairImpl) o;

        return partName.equals(repair.partName);
    }

    @Override
    public int hashCode() {
        return partName.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",this.partName,this.hoursWorked);
    }
}
