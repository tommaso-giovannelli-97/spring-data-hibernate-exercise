package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SkillService {
    @Autowired
    SkillRepository repository;

    public Skill create(Skill skill) {
        return repository.save(skill);
    }

    public List<Skill> findAll () {
        return repository.findAll();
    }

    public Skill findById(Long skillId) {
        Optional<Skill> optionalSkill = repository.findById(skillId);
        return optionalSkill.orElse(null);
    }

    public Skill update(Long skillId, Skill skill) throws Exception {
        Optional<Skill> optionalSkill = repository.findById(skillId);
        if (optionalSkill.isEmpty()) {
            throw new Exception("No existing Skill with the given id");
        }
        return repository.save(skill);
    }

    public void delete(Long skillId) {
        repository.deleteById(skillId);
    }
}
