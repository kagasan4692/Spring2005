public class ClassesAndObject {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("ROMAN", 15);
        person1.speak();

        String p1Name = person1.getName();
        System.out.println(p1Name + "Are");

        Person person2 = new Person();
        person2.speak();
//        person2.sayHello();
        person2.calculateYears();
        int year2 = person2.calculateYears();
        System.out.println(year2);
    }
}

class Person {
    private String name;
    private int age;

    void speak() {
        System.out.println("My name is " + name + ", " + "I am " + age + " years old");
    }

    void sayHello() {
        System.out.println("Hello");
    }

    int calculateYears() {
        int years = 65 - age;
        return years;
    }

    public void setName(String userName, int userAge) {
        name = userName;
        age = userAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}