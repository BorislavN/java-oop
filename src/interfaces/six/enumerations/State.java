package interfaces.six.enumerations;

import java.util.Arrays;

public enum State {
    INPROGRESS("inProgress"),FINISHED("finished");

    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean isValid(String value) {
        return Arrays.stream(State.values()).map(State::getValue).anyMatch(e -> e.equals(value));
    }
}
