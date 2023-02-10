package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
}
