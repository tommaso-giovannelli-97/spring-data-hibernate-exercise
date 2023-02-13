package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.entities.EmployeeProject;
import com.bitrock.springdataproject.entities.Project;
import com.bitrock.springdataproject.entities.ProjectSkill;
import com.bitrock.springdataproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    public List<EmployeeProject> getAllEmployeesWithoutAllProjectSkills() {
        List<ProjectSkill> allProjectsSkills = getAllProjectSkills();

        //Map with projectId ---> List of all skills Ids required for that project
        Map<Long, List<Long>> projectsSkillsMap = EmployeeService.getProjectsSkillsMap(allProjectsSkills);

        List<EmployeeProject> employeesWithoutAllProjectSkills = new ArrayList<>();
        for (Map.Entry<Long,List<Long>> entry : projectsSkillsMap.entrySet()) {
            //All employees working in the project with the given id
            List<Employee> projectEmployees = getEmployeesByProjectId(entry.getKey());
            projectEmployees.stream().filter(employee -> !employee.getAllSkillsIds().containsAll(entry.getValue()))
                    .forEach(employee -> employeesWithoutAllProjectSkills.add(new EmployeeProject(employee, new Project(entry.getKey()))));
        }
        return employeesWithoutAllProjectSkills;
    }


    List<Employee> getEmployeesByProjectId(Long projectId){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);
        Join<Employee, EmployeeProject> project = employee.join("projects");
        cq.where(cb.equal(project.get("project"), new Project(projectId)));

        return entityManager.createQuery(cq).getResultList();

    }

    List<ProjectSkill> getAllProjectSkills() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectSkill> cq = cb.createQuery(ProjectSkill.class);
        Root<ProjectSkill> projectSkill = cq.from(ProjectSkill.class);

        return entityManager.createQuery(cq).getResultList();
    }
}
