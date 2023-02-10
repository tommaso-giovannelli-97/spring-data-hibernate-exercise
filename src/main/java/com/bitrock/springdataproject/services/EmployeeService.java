package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseDbService<Employee> {

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

}
