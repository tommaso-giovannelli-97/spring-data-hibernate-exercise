package com.bitrock.springdataproject.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees_projects")
public class EmployeeProject extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_project_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employeeProject;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    public EmployeeProject(Employee employeeProject, Project project) {
        this.employeeProject = employeeProject;
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeProject)) return false;
        EmployeeProject that = (EmployeeProject) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "EmployeeProject{" +
                "id=" + id +
                ", employeeProject=" + employeeProject +
                ", project=" + project +
                '}';
    }
}
