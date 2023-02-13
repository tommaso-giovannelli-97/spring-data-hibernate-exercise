package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.dtos.EmployeeProjectSkillDto;
import com.bitrock.springdataproject.dtos.ProjectSkillDto;
import com.bitrock.springdataproject.entities.*;
import com.bitrock.springdataproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

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
    @Autowired
    ProjectSkillRepository projectSkillRepository;

    public EmployeeService(JpaRepository<Employee, Long> repository) {
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

    public List<Employee> getAllEmployeesWithoutAGivenSkill(Skill skill, Integer pageNumber, Integer size) {
        Pageable page = PageRequest.of(pageNumber, size);
        return employeeRepository.getAllEmployeesWithoutAGivenSkill(skill.getId(), page);
    }

    public List<EmployeeProject> getAllEmployeesWithoutAllProjectSkills() {
        List<ProjectSkill> allProjectsSkills = projectSkillRepository.findAll();

        //Map with projectId ---> List of all skills Ids required for that project
        Map<Long, List<Long>> projectsSkillsMap = getProjectsSkillsMap(allProjectsSkills);

        List<EmployeeProject> employeesWithoutAllProjectSkills = new ArrayList<>();
        for (Map.Entry<Long,List<Long>> entry : projectsSkillsMap.entrySet()) {
            //All employees working in the project with the given id
            List<Employee> projectEmployees = employeeRepository.getEmployeesByProjectId(entry.getKey());
            projectEmployees.stream().filter(employee -> !employee.getAllSkillsIds().containsAll(entry.getValue()))
                    .forEach(employee -> employeesWithoutAllProjectSkills.add(new EmployeeProject(employee, new Project(entry.getKey()))));
        }
        return employeesWithoutAllProjectSkills;
    }

    public static Map<Long, List<Long>> getProjectsSkillsMap(List<ProjectSkill> allProjectsSkills) {
        return allProjectsSkills.stream()
                .map(ProjectSkillDto::of)
                .collect(groupingBy(ProjectSkillDto::getProjectId))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().map(ProjectSkillDto::getSkillId).collect(Collectors.toList())));
    }
}
