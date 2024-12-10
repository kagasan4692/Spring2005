package Lesson1;

public class ObjectTo {
    public static void main(String[] args) {
        Human1 h1 = new Human1("Rectal", 46);
        System.out.println(h1);
    }
}

class Human1 {
    private String name;
    private int age;

    public Human1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name: " + name + ", " + "age: " + age;
    }
}
