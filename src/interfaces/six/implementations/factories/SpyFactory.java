package interfaces.six.implementations.factories;

import interfaces.six.implementations.SpyImpl;
import interfaces.six.interfaces.Factory;
import interfaces.six.interfaces.Soldier;

public class SpyFactory implements Factory {
    @Override
    public Soldier build(String[] args) {
        return new SpyImpl(
                Integer.parseInt(args[1]),
                args[2],
                args[3],
                args[4]
        );
    }
}
