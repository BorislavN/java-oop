package encapsulation.pizza;

public enum Flour {
    WHITE(1.5),WHOLEGRAIN(1);

    private final double modifier;

    Flour(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}