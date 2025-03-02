package com.kagasan.spring;

import javax.sound.midi.Soundbank;

public class Person {
    private Pet pet;
    private String surname;
    private int age;
//    public Person(Pet pet) {
//        this.pet = pet;
//        System.out.println("Create Person");
//    }

    public Person() {
        System.out.println("Create Person");
    }
    public void setPet(Pet pet){
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely Pet");
        pet.say();
    }
}
