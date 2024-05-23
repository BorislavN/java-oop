package inheritance.animals;

public class Tomcat extends Cat{
    public Tomcat(String name, int age, String gender) {
       this(name, age);
    }

    public Tomcat(String name, int age) {
        super(name,age,"Male");
    }

    @Override
    public String produceSound() {
       return "MEOW";
    }
}
