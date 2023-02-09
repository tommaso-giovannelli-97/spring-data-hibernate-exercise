package com.bitrock.springdataproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees_skills")
public class EmployeeSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_skill_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employeeSkill;

    @ManyToOne
    @JoinColumn(name="skill_id", nullable=false)
    private Skill skill;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Employee employeeSkill, Skill skill) {
        this.employeeSkill = employeeSkill;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployeeSkill() {
        return employeeSkill;
    }

    public void setEmployeeSkill(Employee employeeSkill) {
        this.employeeSkill = employeeSkill;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
