package Lesson1;

public class KeyWorld {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.setName("Sascha");
        human1.setAge(52);
        human1.getInfo();
    }
}

class Human {
    String name;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void getInfo() {
        System.out.println(this.name + this.age);
    }
}

