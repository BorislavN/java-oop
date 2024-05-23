package inheritance.animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        this(name, age);
    }

    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
