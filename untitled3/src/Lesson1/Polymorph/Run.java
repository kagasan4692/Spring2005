package Lesson1.Polymorph;

import sun.rmi.runtime.Log;

public class Run {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
//        animal.eat();
//        dog.eat();
//        dog.bark();
//
//        Animal animal1 = new Dog();
//        animal1.eat();
//        animal1.bark();
//        Dog dog1 = new Dog();
//        dog1.eat();
//        dog1.bark();

        run(animal);
        run(dog);
        run(cat);
    }

    public static void run(Animal animal) {
        animal.eat();
    }

}
