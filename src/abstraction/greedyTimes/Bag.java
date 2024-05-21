package abstraction.greedyTimes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long goldAmount;
    private long gemAmount;
    private long cashAmount;
    private long totalAmount;
    private final Map<String, Item> gold;
    private final Map<String, Item> gems;
    private final Map<String, Item> cash;

    public Bag(long capacity) {
        this.capacity = capacity;

        this.goldAmount = 0L;
        this.gemAmount = 0L;
        this.cashAmount = 0L;
        this.totalAmount = 0L;

        this.gold = new HashMap<>();
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addItem(String name, int amount) {
        if ((this.totalAmount + amount) <= this.capacity) {

            if (name.length() == 3) {
                if (this.gemAmount >= (this.cashAmount + amount)) {
                    this.addAmount(this.cash, name, amount);
                    this.cashAmount += amount;
                }

            } else if (name.toLowerCase().endsWith("gem")) {
                if (this.goldAmount >= (this.gemAmount + amount)) {
                    this.addAmount(this.gems, name, amount);
                    this.gemAmount += amount;
                }

            } else if ("gold".equalsIgnoreCase(name)) {
                this.addAmount(this.gold, name, amount);
                this.goldAmount += amount;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (!this.gold.isEmpty()) {
            builder.append(String.format("<Gold> $%d%n", goldAmount));
            this.appendAll(builder, this.gold.values());
        }

        if (!this.gems.isEmpty()) {
            builder.append(String.format("<Gem> $%d%n", gemAmount));
            this.appendAll(builder, this.gems.values());
        }

        if (!this.cash.isEmpty()) {
            builder.append(String.format("<Cash> $%d%n", cashAmount));
            this.appendAll(builder, this.cash.values());
        }

        return builder.toString().trim();
    }

    private void addAmount(Map<String, Item> type, String name, int amount) {
        String key = name.length() > 3 ? name.toLowerCase() : name;

        type.putIfAbsent(key, new Item(name, 0L));
        type.get(key).addQuantity(amount);

        this.totalAmount += amount;
    }

    private void appendAll(StringBuilder output, Collection<Item> items) {
        items.stream().sorted().forEach(e -> output.append(e).append(System.lineSeparator()));
    }
}