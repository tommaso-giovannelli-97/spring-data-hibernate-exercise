package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
