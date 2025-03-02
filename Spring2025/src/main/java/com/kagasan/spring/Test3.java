package com.kagasan.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
//        Pet pet = new Cat();
//        Person person = new Person(pet);
//        person.callYourPet();
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        Pet pet = context.getBean("myPet", Pet.class);
//        Person person = new Person(pet);
//        person.callYourPet();
        Person person = context.getBean("myPerson", Person.class);
        System.out.println(person.getPet());
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        person.callYourPet();

        context.close();
    }
}
