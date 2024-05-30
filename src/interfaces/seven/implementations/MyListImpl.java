package interfaces.seven.implementations;

import interfaces.seven.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public String remove() {
        return this.getItems().remove(0);
    }

    @Override
    public int add(String value) {
        if (this.getItems().size() < this.getMaxSize()) {
            this.getItems().add(0,value);

            return 0;
        }

        return -1;
    }

    @Override
    public int getUsed() {
        return this.getItems().size();
    }
}
