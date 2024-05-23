package inheritance.animals;

public class Animal {
    private String name;
    private int age;
    private Gender gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            this.throwException();
        }

        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0) {
            this.throwException();
        }

        this.age = age;
    }

    public String getGender() {
        return this.gender.getValue();
    }

    public void setGender(String gender) {
        if (gender == null || gender.isBlank()) {
            this.throwException();
        }

        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public String produceSound() {
        return "Sound";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s"
                , this.getClass().getSimpleName()
                , this.getName()
                , this.getAge()
                , this.getGender()
                , this.produceSound());
    }

    private void throwException() {
        throw new IllegalArgumentException("Invalid input!");
    }
}
