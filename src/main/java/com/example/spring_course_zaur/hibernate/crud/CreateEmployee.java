package com.example.spring_course_zaur.hibernate.crud;

import com.example.spring_course_zaur.hibernate.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Сохранение Java объекта в БД
public class CreateEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // Session - обертка вокруг подключения к базе с помощью JDBC
            Employee emp = new Employee("Robert", "Smith", "IT", 1000);
            session.beginTransaction(); // открытие транзакции
            session.save(emp);
            session.getTransaction().commit(); // закрытие транзакции
        } finally {
            factory.close();
        }
    }
}
