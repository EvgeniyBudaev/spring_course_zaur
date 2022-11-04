package com.example.spring_course_zaur.hibernate.crud;

import com.example.spring_course_zaur.hibernate.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Получение Java объектов из БД
public class GetEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // Создание работника
            Session session = factory.getCurrentSession(); // Session - обертка вокруг подключения к базе с помощью JDBC
            Employee emp = new Employee("Elena", "Petrov", "Sales", 800);
            session.beginTransaction(); // открытие транзакции
            session.save(emp);
            session.getTransaction().commit(); // закрытие транзакции

            // Получение работника
            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId); // employee или null
            session.getTransaction().commit();
            System.out.println(employee);
        } finally {
            factory.close();
        }
    }
}
