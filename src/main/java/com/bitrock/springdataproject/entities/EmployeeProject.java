package com.bitrock.springdataproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
}
