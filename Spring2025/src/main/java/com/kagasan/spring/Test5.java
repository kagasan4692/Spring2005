package com.kagasan.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.login.AccountLockedException;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex =
                new ClassPathXmlApplicationContext("applicationContext1.xml");

        Dog myDog =contex.getBean("myPet", Dog.class);
        myDog.say();

        contex.close();
    }
}
