package com.bitrock.springdataproject.controllers;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.entities.EmployeeProject;
import com.bitrock.springdataproject.entities.EmployeeSkill;
import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.services.EmployeeCriteriaAPIService;
import com.bitrock.springdataproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeCriteriaAPIService employeeCriteriaAPIService;

    @GetMapping
    ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/paginated")
    ResponseEntity<List<Employee>> getAllPaginated(@RequestParam Integer page
            , @RequestParam Integer size, @RequestParam(required = false) String sortColumn) {
        return new ResponseEntity<>(employeeService.findAllPaginated(page, size, sortColumn), HttpStatus.OK);
    }

    @GetMapping("/missingSkill")
    ResponseEntity<List<Employee>> getAllEmployeesWithoutAGivenSkill(@RequestParam Integer page, @RequestParam Integer size, @RequestBody Skill skill){
        return new ResponseEntity<>(employeeService.getAllEmployeesWithoutAGivenSkill(skill, page, size), HttpStatus.OK);
    }

/*    @GetMapping("/withoutAllSkillsForProject")
    ResponseEntity<List<EmployeeProject>> getAllEmployeesWithoutAllProjectSkills() {
        return new ResponseEntity<>(employeeService.getAllEmployeesWithoutAllProjectSkills(), HttpStatus.OK);
    }*/

    @GetMapping("/withoutAllSkillsForProject")
    ResponseEntity<List<EmployeeProject>> getAllEmployeesWithoutAllProjectSkills() {
        return new ResponseEntity<>(employeeCriteriaAPIService.getAllEmployeesWithoutAllProjectSkills(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Employee> save(@RequestBody Employee employee) {
            return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Employee> update(@RequestParam Long employeeId,  @RequestBody Employee employee) throws Exception {
        return new ResponseEntity<>(employeeService.update(employeeId, employee), HttpStatus.CREATED);
    }

    @PostMapping("/skills")
    ResponseEntity<EmployeeSkill> addEmployeeSkill(@RequestParam Long employeeId, @RequestParam Long skillId) throws Exception {
        return new ResponseEntity<>(employeeService.addEmployeeSkill(employeeId, skillId), HttpStatus.CREATED);
    }

    @PostMapping("/projects")
    ResponseEntity<EmployeeProject> addEmployeeProject(@RequestParam Long employeeId, @RequestParam Long projectId) throws Exception {
        return new ResponseEntity<>(employeeService.addEmployeeProject(employeeId, projectId), HttpStatus.CREATED);
    }
}
