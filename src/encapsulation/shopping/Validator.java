package encapsulation.shopping;

public class Validator {
    public static void validateDouble(String fieldName, double value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("%s cannot be negative", fieldName));
        }
    }

    public static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
