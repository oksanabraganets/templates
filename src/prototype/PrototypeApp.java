package prototype;

public class PrototypeApp {

    public static void main(String[] args){
        Human man = new Human("Vasya", 22);
        Human copy = (Human)man.copy();
        System.out.println(copy);
    }
}

interface Copyable{
    Object copy();
}

class Human implements Copyable{

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object copy() {
        Human copy = new Human(name, age);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}