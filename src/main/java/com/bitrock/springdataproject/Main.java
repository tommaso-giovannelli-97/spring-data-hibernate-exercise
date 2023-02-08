package com.bitrock.springdataproject;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.services.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Hibernate session initialization
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeService employeeService = new EmployeeService();

        List<Employee> allEmployees = employeeService.getAllEmployees(session);
        allEmployees.forEach(System.out::println);
    }
}
