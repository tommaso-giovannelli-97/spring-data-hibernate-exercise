package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Employee;
import com.bitrock.springdataproject.entities.EmployeeSkill;
import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.repositories.EmployeeRepository;
import com.bitrock.springdataproject.repositories.EmployeeSkillRepository;
import com.bitrock.springdataproject.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService extends BaseDbService<Employee> {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;
    @Autowired
    SkillRepository skillRepository;

    public EmployeeService(EmployeeRepository repository) {
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
}
