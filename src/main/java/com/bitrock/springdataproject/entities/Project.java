package com.bitrock.springdataproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Project() {
    }

    public Project(Long id) {
        this.id = id;
    }

    public Project(String projectName, Customer customer, Set<EmployeeProject> employees) {
        this.projectName = projectName;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
