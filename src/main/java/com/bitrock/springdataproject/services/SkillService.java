package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Skill;
import com.bitrock.springdataproject.repositories.SkillRepository;
import org.springframework.stereotype.Service;


@Service
public class SkillService extends BaseDbService<Skill> {
    public SkillService(SkillRepository repository) {
        super(repository);
    }
}
