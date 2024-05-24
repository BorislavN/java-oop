package encapsulation.pizza;

public class Validator {
    public static void validateDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void validateToppingWeight(String type, double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", type));
        }
    }

    public static void validatePizzaName(String name) {
        if (name == null || name.isBlank() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void validateNumberOfToppings(int size) {
        if (size < 0 || size > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public static void checkFlourType(String value) {
        rethrowException("Invalid type of dough.", () -> Helper.enumValue(Flour.class, value));
    }

    public static void checkDoughTechnique( String value) {
        rethrowException("Invalid type of dough.", () -> Helper.enumValue(Technique.class, value));

    }

    public static void checkToppingType( String value) {
        rethrowException( String.format("Cannot place %s on top of your pizza."
                , value), () -> Helper.enumValue(ToppingType.class, value)
        );
    }

    private static void rethrowException(String message, VoidFunction function) {
        try {
            function.apply();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
