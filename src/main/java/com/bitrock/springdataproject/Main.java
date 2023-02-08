package com.bitrock.springdataproject;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.entities.Project;
import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.services.EmployeeService;
import com.bitrock.springdataproject.services.SkillService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Hibernate session initialization
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeService employeeService = new EmployeeService(session);

        List<Employee> allEmployees = employeeService.getAllEmployees();
        //allEmployees.forEach(System.out::println);
        Employee employeeById = employeeService.getEmployeeById(2L);
        //System.out.println(employeeById);

        Employee newEmployee = new Employee(2L,"Mario","Rossi",45);
        //employeeService.createEmployee(newEmployee);
        //employeeService.deleteEmployeeById(14L);
        //employeeService.updateEmployee(17L, newEmployee);

        session.close();
    }
}
