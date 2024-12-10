package Lesson1.VariableMetods;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Run {
    public static void main(String[] args) {
        //Upcasting
        Animal animal = new Dog();
        animal.eat();
        ((Dog) animal).say();

        //Downcasting
        Dog dog1 = (Dog) animal;
        dog1.say();
    }
}
