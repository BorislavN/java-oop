package encapsulation.pizza;

public class Helper {
    public static <T extends Enum<T>> T enumValue(Class<T> clazz, String type) {
        return Enum.valueOf(clazz, type.toUpperCase());
    }
}
