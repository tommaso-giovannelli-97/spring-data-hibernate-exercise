package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Skill;
import org.hibernate.Session;

public class SkillService extends BaseDbService<Skill>{

    public void updateSkill(Long skillId, Skill skill) {
        Session session = getSession();
        Skill oldSkill = getEntityById("Select s from Skill s where s.id = :id", skillId);

        if(oldSkill != null) {
            skill.setId(skillId);
            session.update(skill);
            session.flush(); //To make update work!
        }
        session.close();
    }
}
