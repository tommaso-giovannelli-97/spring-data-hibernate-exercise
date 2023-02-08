package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Skill;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SkillService {

    private final Session session;

    public SkillService(Session session) {
        this.session = session;
    }

    public List<Skill> getAllSkills() {
        String hqlQuery = "Select s from Skill s";
        Query query = session.createQuery(hqlQuery);
        return query.getResultList();
    }

    public Skill getSkillById(Long skillId) {
        String hqlQuery = "Select s from Skill s where s.id = :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",skillId);
        return (Skill) query.uniqueResult();
    }

    public void createSkill(Skill skill) {
        session.save(skill);
    }

    //To implement
    public void updateSkill(Long skillId, Skill skill) {
    }

    public void deleteSkillById(Long skillId) {
        String hqlQuery = "delete from Skill s where s.id= :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",skillId);
        query.executeUpdate();
    }
}
