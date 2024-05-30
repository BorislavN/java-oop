package interfaces.six.interfaces;

import interfaces.six.enumerations.State;

public interface Mission {
    String getCodeName();

    State getState();

    void completeMission();
}
