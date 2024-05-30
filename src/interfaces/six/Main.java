package interfaces.six;

import interfaces.six.implementations.factories.*;
import interfaces.six.interfaces.Factory;
import interfaces.six.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Soldier> military = new LinkedHashMap<>();
        Map<String, Factory> factories = new HashMap<>();

        factories.put("Private", new PrivateFactory());
        factories.put("LieutenantGeneral", new LieutenantGeneralFactory(military));
        factories.put("Engineer", new EngineerFactory());
        factories.put("Commando", new CommandoFactory());
        factories.put("Spy", new SpyFactory());

        String input;

        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            Factory factory = factories.get(data[0]);

            if (factory != null) {
                Soldier newSoldier = factory.build(data);

                if (newSoldier != null) {
                    military.putIfAbsent(newSoldier.getId(), newSoldier);
                }
            }
        }

        military.values().forEach(System.out::println);
    }
}