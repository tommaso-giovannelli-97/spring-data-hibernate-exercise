package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.*;
import com.bitrock.springdataproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends BaseDbService<Employee> {

    //Repository for Custom methods
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeSkillRepository employeeSkillRepository;
    @Autowired
    EmployeeProjectRepository employeeProjectRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    ProjectRepository projectRepository;

    public EmployeeService(JpaRepository<Employee,Long> repository) {
        super(repository);
    }

    public EmployeeSkill addEmployeeSkill(Long employeeId, Long skillId) throws Exception {
        Optional<Employee> optEmployee = repository.findById(employeeId);
        Optional<Skill> optSkill = skillRepository.findById(skillId);

        if (optEmployee.isEmpty() || optSkill.isEmpty()) {
            throw new Exception("No existing Employee or Skill with given ids");
        }
        Employee employee = new Employee(employeeId);
        Skill skill = new Skill(skillId);
        EmployeeSkill employeeSkill = new EmployeeSkill(employee, skill);
        return employeeSkillRepository.save(employeeSkill);
    }

    public EmployeeProject addEmployeeProject(Long employeeId, Long projectId) throws Exception {
        Optional<Employee> optEmployee = repository.findById(employeeId);
        Optional<Project> optProject = projectRepository.findById(projectId);

        if (optEmployee.isEmpty() || optProject.isEmpty()) {
            throw new Exception("No existing Employee or Project with given ids");
        }
        Employee employee = new Employee(employeeId);
        Project project = new Project(projectId);
        EmployeeProject employeeProject = new EmployeeProject(employee, project);
        return employeeProjectRepository.save(employeeProject);
    }

    public List<Employee> getAllEmployeesWithoutAGivenSkill (Skill skill) {
        return employeeRepository.getAllEmployeesWithoutAGivenSkill(skill.getId());
    }
}
