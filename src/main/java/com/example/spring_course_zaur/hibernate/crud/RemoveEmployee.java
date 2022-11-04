package com.example.spring_course_zaur.hibernate.crud;

import com.example.spring_course_zaur.hibernate.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RemoveEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1); // employee или null
            session.delete(employee); // удаление объекта из БД

            // Второй вариант, если удаляем по условию или удаляем несколько объектов
            session.createQuery("delete Employee " +
                    "where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
