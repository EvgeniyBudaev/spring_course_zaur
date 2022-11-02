package com.example.spring_course_zaur.ioc_di.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// Bean Scope
public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        System.out.println(myDog == yourDog); // singleton - true

        Person person1 = context.getBean("myPerson", Person.class);
        Person person2 = context.getBean("myPerson", Person.class);
        System.out.println(person1 == person2); // prototype - false

        context.close();
    }
}
