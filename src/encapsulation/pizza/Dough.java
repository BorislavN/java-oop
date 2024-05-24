package encapsulation.pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public double calculateCalories() {
        return (2 * this.weight)
                * Helper.enumValue(Flour.class, this.flourType).getModifier()
                * Helper.enumValue(Technique.class, this.bakingTechnique).getModifier();
    }

    private void setFlourType(String flourType) {
        Validator.checkFlourType(flourType);

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.checkDoughTechnique(bakingTechnique);

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Validator.validateDoughWeight(weight);

        this.weight = weight;
    }
}
