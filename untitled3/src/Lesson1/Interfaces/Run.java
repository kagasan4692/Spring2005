package Lesson1.Interfaces;

public class Run {
    public static void main(String[] args) {

        Info info1 = new Animal(2);
        Info info2 = new Person("Robert");
//        info1.showInfo();
//        info2.showInfo();
        outputInfo(new Animal(10));

    }

    public static void outputInfo(Info info) {
        info.showInfo();
    }
}
