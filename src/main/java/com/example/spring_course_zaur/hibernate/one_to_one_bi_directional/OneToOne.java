package com.example.spring_course_zaur.hibernate.one_to_one_bi_directional;

import com.example.spring_course_zaur.hibernate.one_to_one_bi_directional.entity.Detail;
import com.example.spring_course_zaur.hibernate.one_to_one_bi_directional.entity.Employee;
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
//            detail.setEmployee(employee);
//
//            session.beginTransaction();
//            session.save(detail);
//            session.getTransaction().commit();

            // Получение
            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            System.out.println(detail.getEmployee());
            session.getTransaction().commit();

            // Удаление
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 1);
//            detail.getEmployee().setEmpDetail(null); // в случае удаление только деталей
//            session.delete(detail);
//            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
