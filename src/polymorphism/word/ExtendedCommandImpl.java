package polymorphism.word;

import java.util.ArrayList;
import java.util.List;

public class ExtendedCommandImpl extends CommandImpl {
    private String clipboard;

    public ExtendedCommandImpl(StringBuilder text) {
        super(text);
        this.clipboard = "";
    }

    @Override
    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new CutTransform()));
        commands.add(new Command("paste", new PasteTransform()));

        return commands;
    }

     class CutTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            if (startIndex == endIndex) {
                clipboard = "";

                return;
            }

            clipboard = text.substring(startIndex, endIndex);
            text.delete(startIndex, endIndex);
        }
    }

     class PasteTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            if (startIndex == endIndex) {
                text.insert(startIndex, clipboard);

                return;
            }

            text.replace(startIndex, endIndex, clipboard);
        }
    }
}
