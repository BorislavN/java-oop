package interfaces.six.implementations.comparator;

import interfaces.six.interfaces.Private;

import java.util.Comparator;

public class PrivateComparator implements Comparator<Private> {
    @Override
    public int compare(Private one, Private two) {
        return Integer.compare(two.getId(), one.getId());
    }
}
