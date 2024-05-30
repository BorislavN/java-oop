package interfaces.six.enumerations;

import java.util.Arrays;

public enum Corps {
    AIRFORCES("Airforces"), MARINES("Marines");

    private final String name;

    Corps(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static boolean isValid(String value) {
        return Arrays.stream(Corps.values()).map(Corps::getName).anyMatch(e -> e.equals(value));
    }
}
