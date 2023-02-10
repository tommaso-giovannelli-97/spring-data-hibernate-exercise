package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.*;
import org.hibernate.Session;

import java.util.Optional;

public class EmployeeService extends BaseDbService<Employee>{

    private final SkillService skillService = new SkillService();
    private final ProjectService projectService = new ProjectService();

    public void updateEmployee(Long employeeId, Employee employee) {
        Session session = getSession();
        Employee oldEmployee = getById("Select e from Employee e where e.id = :id", employeeId);

        if(oldEmployee != null) {
            employee.setId(employeeId);
            session.update(employee);
            session.flush(); //To make update work!
        }
        session.close();
    }

    public void addEmployeeSkill(Long employeeId, Long skillId) throws Exception {
        Session session = getSession();

        final String getEmployeeByIdHql = "Select e from Employee e where e.id = :id";
        final String getSkillByIdHql = "Select s from Skill s where s.id = :id";

        Optional<Employee> optEmployee = Optional.ofNullable(getById(getEmployeeByIdHql, employeeId));
        Optional<Skill> optSkill = Optional.ofNullable(skillService.getById(getSkillByIdHql, skillId));

        if (optEmployee.isEmpty() || optSkill.isEmpty()) {
            throw new Exception("No existing Employee or Skill with given ids");
        }
        Employee employee = new Employee(employeeId);
        Skill skill = new Skill(skillId);
        EmployeeSkill employeeSkill = new EmployeeSkill(employee, skill);
        session.save(employeeSkill);
        session.close();
    }

    public void addEmployeeProject(Long employeeId, Long projectId) throws Exception {
        Session session = getSession();

        final String getEmployeeByIdHql = "Select e from Employee e where e.id = :id";
        final String getProjectByIdHql = "Select p from Project p where p.id = :id";

        Optional<Employee> optEmployee = Optional.ofNullable(getById(getEmployeeByIdHql, employeeId));
        Optional<Project> optProject = Optional.ofNullable(projectService.getById(getProjectByIdHql, projectId));

        if (optEmployee.isEmpty() || optProject.isEmpty()) {
            throw new Exception("No existing Employee or Project with given ids");
        }
        Employee employee = new Employee(employeeId);
        Project project = new Project(projectId);
        EmployeeProject employeeProject = new EmployeeProject(employee, project);
        session.save(employeeProject);
        session.close();
    }
}
