package interfaces.seven.implementations;

import interfaces.seven.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
    }

    @Override
    public String remove() {
        return this.getItems().remove(this.getItems().size() - 1);
    }

    @Override
    public int add(String value) {
        if (this.getItems().size() < this.getMaxSize()) {
            this.getItems().add(0, value);

            return 0;
        }

        return -1;
    }
}
