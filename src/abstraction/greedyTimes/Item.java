package abstraction.greedyTimes;

public class Item implements Comparable<Item> {
    private final String name;
    private long quantity;

    public Item(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }


    @Override
    public int compareTo(Item other) {
        int result = other.getName().compareTo(this.getName());

        if (result == 0) {
            result = Long.compare(this.quantity, other.getQuantity());
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d", this.getName(), this.getQuantity());
    }
}