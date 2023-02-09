package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import org.hibernate.Session;

public class EmployeeService extends BaseDbService<Employee>{

    public void updateEmployee(Long employeeId, Employee employee) {
        Session session = getSession();
        Employee oldEmployee = getEntityById("Select e from Employee e where e.id = :id", employeeId);

        if(oldEmployee != null) {
            employee.setId(employeeId);
            session.update(employee);
            session.flush(); //To make update work!
        }
        session.close();
    }
}
