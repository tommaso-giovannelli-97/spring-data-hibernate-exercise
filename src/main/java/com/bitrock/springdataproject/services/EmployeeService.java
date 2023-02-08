package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService {
    public List<Employee> getAllEmployees(Session session) {
        String queryString = "Select e from Employee e";
        Query query = session.createQuery(queryString);
        return query.getResultList();
    }
}
