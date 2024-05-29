package interfaces.five;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        String numberRegex = ".*\\d+.*";
        String pattern = "Browsing: %s!";

        return this.iterate(this.urls, numberRegex, pattern, "Invalid URL!");
    }

    @Override
    public String call() {
        String nonNumberRegex = ".*\\D+.*";
        String pattern = "Calling... %s";

        return this.iterate(this.numbers, nonNumberRegex, pattern, "Invalid number!");
    }

    private String iterate(Collection<String> collection, String regex, String validPattern, String invalidMessage) {
        StringBuilder output = new StringBuilder();

        for (String element : collection) {
            if (Pattern.matches(regex, element)) {
                output.append(invalidMessage);
            } else {
                output.append(String.format(validPattern, element));
            }

            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
