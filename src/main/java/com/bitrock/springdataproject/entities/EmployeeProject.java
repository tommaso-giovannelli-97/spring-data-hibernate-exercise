package com.bitrock.springdataproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees_projects")
public class EmployeeProject {
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

    public EmployeeProject() {
    }

    public EmployeeProject(Employee employeeProject, Project project) {
        this.employeeProject = employeeProject;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(Employee employeeProject) {
        this.employeeProject = employeeProject;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
