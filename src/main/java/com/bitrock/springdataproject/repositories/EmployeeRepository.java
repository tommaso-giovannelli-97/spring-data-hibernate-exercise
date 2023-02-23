package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT DISTINCT e FROM Employee e LEFT JOIN e.skills s WHERE :skillId " +
            "not in (select s2.skill.id from Employee e2 " +
            "INNER JOIN e2.skills s2 " +
            "WHERE e2.id = e.id) " +
            "order by e.id")
    List<Employee> getAllEmployeesWithoutAGivenSkill(Long skillId, Pageable pageable);

    @Query("SELECT e FROM Employee e INNER JOIN e.projects p WHERE p.project.id = :projectId")
    List<Employee> getEmployeesByProjectId(Long projectId);

    @Query("select e from Employee e where e.birthday < :date")
    List<Employee> getAllWithBirthdayBeforeGivenDate(
            LocalDate date);
}
