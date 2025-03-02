package com.kagasan.spring;

public class Dog implements Pet {
    private String name;
    Dog(){
        System.out.println("Create Dog");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    public void init() {
        System.out.println("Class Dog: init method");
    }

    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
