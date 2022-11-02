package com.example.spring_course_zaur.ioc_di.spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        // сначала убираем аннотации @Component, @Autowired в классах
        // все бины описываем внутри класса MyConfig2
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);

        Pet cat = context.getBean("cat", Cat.class);
        cat.say();

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }
}
