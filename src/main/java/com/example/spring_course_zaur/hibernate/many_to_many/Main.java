package com.example.spring_course_zaur.hibernate.many_to_many;

import com.example.spring_course_zaur.hibernate.many_to_many.entity.Child;
import com.example.spring_course_zaur.hibernate.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            // Создание
            // Вариант 1
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Bob", 15);
//            Child child2 = new Child("Tom", 17);
//            Child child3 = new Child("Mike", 16);
//            session.beginTransaction();
//            session.save(section1);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);
//            session.getTransaction().commit();

            // Вариант 2
            session = factory.getCurrentSession();
            Section section1 = new Section("Football");
            Child child1 = new Child("Bob", 15);
            Child child2 = new Child("Tom", 17);
            Child child3 = new Child("Mike", 16);
            session.beginTransaction();
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);
            session.persist(section1);
            session.getTransaction().commit();


            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");
            Child child4 = new Child("Leo", 18);
            child4.addSectionToChild(section2);
            child4.addSectionToChild(section3);
            session.beginTransaction();
            session.save(child4);
            session.getTransaction().commit();

            // Получение
            session = factory.getCurrentSession();
            session.beginTransaction();
            Section section = session.get(Section.class, 1);
            System.out.println(section);
            System.out.println(section.getChildren());

            Child child = session.get(Child.class, 1);
            System.out.println(child);
            System.out.println(child.getSections());
            session.getTransaction().commit();

            // Удаление
            session = factory.getCurrentSession();
            session.beginTransaction();
            Section sectionForDelete = session.get(Section.class, 1);
            session.delete(sectionForDelete);

            Child childForDelete = session.get(Child.class, 1);
            session.delete(childForDelete);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
