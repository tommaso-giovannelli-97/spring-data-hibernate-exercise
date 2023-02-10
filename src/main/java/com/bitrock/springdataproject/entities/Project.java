package com.bitrock.springdataproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "projects")
public class Project extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Project(Long id) {
        this.id = id;
    }
}
