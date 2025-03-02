package com.kagasan.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext1.xml");



        context.close();
    }
}
