package com.example.spring_course_zaur.hibernate.crud;

import com.example.spring_course_zaur.hibernate.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetEmployees {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // Session - обертка вокруг подключения к базе с помощью JDBC
            session.beginTransaction(); // открытие транзакции
            List<Employee> employeeList = session.createQuery("from Employee").getResultList(); // получение всех работников
            List<Employee> employeeByQuery = session.createQuery("from Employee " + "where name = 'Elena'").getResultList(); // name - название поля класса
            List<Employee> employeeByQuery2 = session.createQuery("from Employee " + "where name = 'Elena' AND salary > 600").getResultList();
            for (Employee employee: employeeList) {
                System.out.println("Employee: " + employee);
            }
            System.out.println("Elena: " + employeeByQuery);
            session.getTransaction().commit(); // закрытие транзакции

        } finally {
            factory.close();
        }
    }
}
