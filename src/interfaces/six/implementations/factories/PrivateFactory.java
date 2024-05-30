package interfaces.six.implementations.factories;

import interfaces.six.implementations.PrivateImpl;
import interfaces.six.interfaces.Factory;
import interfaces.six.interfaces.Soldier;

public class PrivateFactory implements Factory {
    @Override
    public Soldier build(String[] args) {
        return new PrivateImpl(
                Integer.parseInt(args[1]),
                args[2],
                args[3],
                Double.parseDouble(args[4])
        );
    }
}
