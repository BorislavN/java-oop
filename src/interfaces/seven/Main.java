package interfaces.seven;

import interfaces.seven.implementations.AddCollection;
import interfaces.seven.implementations.AddRemoveCollection;
import interfaces.seven.implementations.MyListImpl;
import interfaces.seven.interfaces.AddRemovable;
import interfaces.seven.interfaces.Addable;
import interfaces.seven.interfaces.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Addable addable = new AddCollection();
        AddRemovable addRemovable = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        StringBuilder outputOne = new StringBuilder();
        StringBuilder outputTwo = new StringBuilder();
        StringBuilder outputThree = new StringBuilder();
        StringBuilder outputFour = new StringBuilder();
        StringBuilder outputFive = new StringBuilder();

        String[] data = reader.readLine().split("\\s+");
        int toBeRemoved = Integer.parseInt(reader.readLine());

        for (String element : data) {
            append(outputOne, addable.add(element));
            append(outputTwo, addRemovable.add(element));
            append(outputThree, myList.add(element));
        }

        while (toBeRemoved-- > 0) {
            append(outputFour, addRemovable.remove());
            append(outputFive, myList.remove());
        }

        System.out.println(outputOne);
        System.out.println(outputTwo);
        System.out.println(outputThree);
        System.out.println(outputFour);
        System.out.println(outputFive);
    }

    private static <T> void append(StringBuilder builder, T element) {
        builder.append(element).append(" ");
    }
}
