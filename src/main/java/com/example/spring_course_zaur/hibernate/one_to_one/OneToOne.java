package com.example.spring_course_zaur.hibernate.one_to_one;

import com.example.spring_course_zaur.hibernate.one_to_one.entity.Detail;
import com.example.spring_course_zaur.hibernate.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            // Создание
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Bob", "Marley", "IT", 500);
//            Detail detail = new Detail("Moscow", "84957776655", "marley@gmail.com");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();

            // Получение
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getEmpDetail());
            session.getTransaction().commit();

            // Удаление
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);
//            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
