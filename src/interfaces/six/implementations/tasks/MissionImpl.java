package interfaces.six.implementations.tasks;

import interfaces.six.enumerations.State;
import interfaces.six.interfaces.Mission;

public class MissionImpl implements Mission {
    private final String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        if (State.INPROGRESS.ordinal() == this.state.ordinal()) {
            this.state = State.FINISHED;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionImpl mission = (MissionImpl) o;

        return codeName.equals(mission.codeName);
    }

    @Override
    public int hashCode() {
        return codeName.hashCode();
    }


    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.codeName,this.state.getValue());
    }

    private void setState(String state) {
        this.state = State.valueOf(state.toUpperCase());
    }
}
