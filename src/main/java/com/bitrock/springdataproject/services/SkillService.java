package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillService extends BaseDbService<Skill> {

    //Repository for Custom methods
    @Autowired
    SkillRepository skillRepository;

    public SkillService(SkillRepository repository) {
        super(repository);
    }

    public List<Skill> getAllWithMoreThanOneEmployee() {
        return skillRepository.getAllWithMoreThanOneEmployee();
    }
}
