package interfaces.fourth;

public class Citizen implements Person, Identifiable, Birthable, Buyer {
    private static final int FOOD_SIZE = 10;
    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void buyFood() {
        this.food += FOOD_SIZE;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
