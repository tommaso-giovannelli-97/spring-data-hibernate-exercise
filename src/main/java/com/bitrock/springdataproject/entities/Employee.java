package com.bitrock.springdataproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity{
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

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "skillEmployee", cascade = CascadeType.ALL)
    private Set<EmployeeSkill> skills;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeProject", cascade = CascadeType.ALL)
    private Set<EmployeeProject> projects;

    public Employee(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId().equals(employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @JsonIgnore
    public List<Long> getAllSkillsIds(){
        return skills.stream()
                .map(EmployeeSkill :: getSkill)
                .map( Skill :: getId)
                .collect(Collectors.toList());
    }
}