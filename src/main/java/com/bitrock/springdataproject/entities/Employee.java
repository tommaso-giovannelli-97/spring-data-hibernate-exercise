package com.bitrock.springdataproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "age",nullable = false)
    private Integer age;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeSkill", cascade = CascadeType.ALL)
    private Set<EmployeeSkill> skills;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeProject", cascade = CascadeType.ALL)
    private Set<EmployeeProject> projects;

    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Employee(String name, String surname, Integer age, Set<EmployeeSkill> skills, Set<EmployeeProject> projects) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.skills = skills;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<EmployeeProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<EmployeeProject> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                ", projects=" + projects +
                '}';
    }
}