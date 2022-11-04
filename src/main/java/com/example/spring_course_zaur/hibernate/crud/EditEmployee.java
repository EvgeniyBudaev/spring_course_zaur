package com.example.spring_course_zaur.hibernate.crud;

import com.example.spring_course_zaur.hibernate.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EditEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1); // employee или null
            employee.setSalary(1500); // Меняем зарплату сотруднику

            session.createQuery("update Employee set salary=900 " +
                    "where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
