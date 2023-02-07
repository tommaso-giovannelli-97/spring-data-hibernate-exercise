package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> findAll () {
        return repository.findAll();
    }

    public Employee findById(Long employeeId) {
        Optional<Employee> optionalEmployee = repository.findById(employeeId);
        return optionalEmployee.orElse(null);
    }

    public Employee update(Long employeeId, Employee employee) throws Exception {
        Optional<Employee> optionalEmployee = repository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new Exception("No existing employee with the given id");
        }
        return repository.save(employee);
    }

    public void delete(Long employeeId) {
        repository.deleteById(employeeId);
    }
}
