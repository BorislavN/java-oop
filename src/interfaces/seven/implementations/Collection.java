package interfaces.seven.implementations;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int maxSize;

    private final List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
        this.maxSize = 100;
    }

    protected int getMaxSize() {
        return this.maxSize;
    }

    protected List<String> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        return String.join(" ", this.items);
    }
}
