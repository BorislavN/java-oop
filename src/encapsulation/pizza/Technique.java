package encapsulation.pizza;

public enum Technique {
    CRISPY (0.9),CHEWY (1.1) ,HOMEMADE (1.0);

    private final double modifier;

    Technique(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
