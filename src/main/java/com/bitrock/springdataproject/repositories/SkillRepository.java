package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query(value = "select s.skill_id , s.skill_name " +
            "from skills s " +
            "inner join employees_skills es on s.skill_id = es.skill_id " +
            "group by s.skill_id " +
            "having COUNT(es.employee_id)>=2", nativeQuery = true)
    List<Skill> getAllWithMoreThanOneEmployee();
}
