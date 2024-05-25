package encapsulation.football;

public class Validator {
    public static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateStat(String statName, int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

    public static <T> void validateNotNull(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Argument is null!");
        }
    }

    //If the condition is not met, an IllegalArgumentException is thrown
    public static void testCondition(String error, SimplePredicate predicate) {
        if (!predicate.test())
            throw new IllegalArgumentException(error);
    }
}