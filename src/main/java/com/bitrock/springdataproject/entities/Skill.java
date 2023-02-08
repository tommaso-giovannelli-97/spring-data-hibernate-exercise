package com.bitrock.springdataproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_name",nullable = false)
    private String skillName;

    //@ManyToMany(mappedBy = "skills")
    //Set<Employee> employees;


    public Skill() {
    }

    public Skill(Long id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
