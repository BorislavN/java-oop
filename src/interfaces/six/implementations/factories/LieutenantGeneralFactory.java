package interfaces.six.implementations.factories;

import interfaces.six.implementations.LieutenantGeneralImpl;
import interfaces.six.interfaces.Factory;
import interfaces.six.interfaces.LieutenantGeneral;
import interfaces.six.interfaces.Private;
import interfaces.six.interfaces.Soldier;

import java.util.Map;

public class LieutenantGeneralFactory implements Factory {
    private final Map<Integer, Soldier> military;

    public LieutenantGeneralFactory(Map<Integer, Soldier> military) {
        this.military = military;
    }

    @Override
    public Soldier build(String[] args) {
        LieutenantGeneral newLieutenant = new LieutenantGeneralImpl(
                Integer.parseInt(args[1]), args[2], args[3], Double.parseDouble(args[4])
        );

        for (int index = 5; index < args.length; index++) {
            int privateId = Integer.parseInt(args[index]);

            Soldier temp = this.military.get(privateId);

            if (temp instanceof Private) {
                newLieutenant.addPrivate((Private) temp);
            }
        }

        return newLieutenant;
    }
}
