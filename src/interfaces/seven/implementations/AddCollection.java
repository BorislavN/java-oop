package interfaces.seven.implementations;

import interfaces.seven.interfaces.Addable;

public class AddCollection extends Collection implements Addable {
    public AddCollection() {
    }

    @Override
    public int add(String value) {
        int index = this.getItems().size();

        if (index < this.getMaxSize()) {
            this.getItems().add(value);

            return index;
        }

        return -1;
    }
}
