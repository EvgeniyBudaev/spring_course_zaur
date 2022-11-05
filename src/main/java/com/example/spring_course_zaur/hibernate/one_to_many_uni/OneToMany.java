package com.example.spring_course_zaur.hibernate.one_to_many_uni;

import com.example.spring_course_zaur.hibernate.one_to_many_uni.entity.Employee;
import com.example.spring_course_zaur.hibernate.one_to_many_uni.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            // Создание
//            session = factory.getCurrentSession();
//            Department department = new Department("IT", 300, 1200);
//            Employee employee1 = new Employee("Bob", "Marley", 500);
//            Employee employee2 = new Employee("Kian", "Riv", 1000);
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            session.beginTransaction();
//            session.save(department);
//            session.getTransaction().commit();

            // Получение
            session = factory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            System.out.println("Department: " + department);
            System.out.println("Employees to department: " + department.getEmps());
            Employee employee = session.get(Employee.class, 1);
            System.out.println("Employee: " + employee);
            session.getTransaction().commit();

            // Удаление
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);
//            Department department = session.get(Department.class, 1);
//            session.delete(department); // удалится департамент и все его работники
//            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
