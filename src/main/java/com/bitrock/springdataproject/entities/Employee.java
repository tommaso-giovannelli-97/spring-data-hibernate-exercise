package com.bitrock.springdataproject.entities;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employees")
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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employees_skills",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private Set<Skill> skills;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employees_projects",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private Set<Project> projects;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, Integer age, Set<Skill> skills, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.skills = skills;
        this.projects = projects;
    }

    public Employee(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                ", projects=" + projects +
                '}';
    }
}