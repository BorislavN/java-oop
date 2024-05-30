package interfaces.six.implementations;

import interfaces.six.implementations.comparator.PrivateComparator;
import interfaces.six.interfaces.LieutenantGeneral;
import interfaces.six.interfaces.Private;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>(new PrivateComparator());
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString()).append(System.lineSeparator());
        output.append("Privates:").append(System.lineSeparator());

        this.privates.forEach(p -> output.append(p).append(System.lineSeparator()));

        return output.toString().trim();
    }
}
