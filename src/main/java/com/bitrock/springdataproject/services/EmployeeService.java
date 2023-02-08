package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService {

    private final Session session;

    public EmployeeService(Session session) {
        this.session = session;
    }

    public List<Employee> getAllEmployees() {
        String hqlQuery = "Select e from Employee e";
        Query query = session.createQuery(hqlQuery);
        return query.getResultList();
    }

    public Employee getEmployeeById(Long employeeId) {
        String hqlQuery = "Select e from Employee e where e.id = :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",employeeId);
        return (Employee) query.uniqueResult();
    }

    public void createEmployee(Employee employee) {
        session.save(employee);
    }

    public void updateEmployee(Long employeeId, Employee employee) {

        Employee oldEmployee = getEmployeeById(employeeId);

        if(oldEmployee != null) {
            Query query = session.createQuery("update Employee e set e.name = :name, e.surname=:surname, e.age=:age where e.id = :id");
            query.setParameter("id", employeeId);
            query.setParameter("name", employee.getName());
            query.setParameter("surname", employee.getSurname());
            query.setParameter("age", employee.getAge());

            query.executeUpdate();
        }

    }

    public void deleteEmployeeById(Long employeeId) {
        String hqlQuery = "delete from Employee e where e.id= :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",employeeId);
        query.executeUpdate();
    }
}
