package polymorphism.word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new ExtendedCommandImpl(text);
        commandInterface.init();

        return commandInterface;
    }
}
