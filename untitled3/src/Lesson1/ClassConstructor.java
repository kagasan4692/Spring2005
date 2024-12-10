public class ClassConstructor {
    public static void main(String[] args) {
        Human human1 = new Human("Georgy", 63);
        Human human2 = new Human("Alex", 52);
        Human human3 = new Human("Dimitry", 26);

        System.out.println(human1.getName());
        Human.description = "Nice";
        human1.getAllFielg();
        human2.getAllFielg();
        human3.getAllFielg();

        Human.description = "BAd";
        human1.getAllFielg();
        human2.getAllFielg();
        human3.getAllFielg();

        Human.getStaticFields();

        human1.getCountPeople();
        human2.getCountPeople();
    }
}

class Human {
    private String name;
    private int age;
    public static String description;
    public static String Price = "10 000.00";

    private static int countPeople;

    public Human(String name, int age) {
        System.out.println("CONSTRUCTOR-3");
        this.name = name;
        this.age = age;
        countPeople++;
        getCountPeople();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public static void getDescription() {
        System.out.println(description);
    }

    public void getAllFielg() {
        System.out.println(name + ", " + age + ", " + description);
    }

    public static void getStaticFields() {
        System.out.println(description + ", " + Price + ", " + countPeople);
    }

    public void getCountPeople() {
        System.out.println(countPeople);
    }
}
