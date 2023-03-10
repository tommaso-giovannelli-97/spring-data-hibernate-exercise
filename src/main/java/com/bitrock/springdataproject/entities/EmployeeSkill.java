package com.bitrock.springdataproject.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees_skills")
public class EmployeeSkill extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_skill_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee skillEmployee;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    public EmployeeSkill(Employee skillEmployee, Skill skill) {
        this.skillEmployee = skillEmployee;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeSkill)) return false;
        EmployeeSkill that = (EmployeeSkill) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "id=" + id +
                ", skillEmployee=" + skillEmployee +
                ", skill=" + skill +
                '}';
    }
}
