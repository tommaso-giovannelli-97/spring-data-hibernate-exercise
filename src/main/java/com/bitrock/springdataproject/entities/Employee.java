package com.bitrock.springdataproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "skillEmployee", cascade = CascadeType.ALL)
    private Set<EmployeeSkill> skills;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeProject", cascade = CascadeType.ALL)
    private Set<EmployeeProject> projects;

    public Employee(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId().equals(employee.getId()) && getName().equals(employee.getName()) && getSurname().equals(employee.getSurname()) && getAge().equals(employee.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAge());
    }
}