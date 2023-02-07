package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
