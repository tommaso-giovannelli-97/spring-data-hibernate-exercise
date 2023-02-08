package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectService {

    private final Session session;

    public ProjectService(Session session) {
        this.session = session;
    }

    public List<Project> getAllProjects() {
        String hqlQuery = "Select p from Project p";
        Query query = session.createQuery(hqlQuery);
        return query.getResultList();
    }

    public Project getProjectById(Long projectId) {
        String hqlQuery = "Select p from Project p where p.id = :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",projectId);
        return (Project) query.uniqueResult();
    }

    public void createProject(Project project) {
        session.save(project);
    }

    //To implement
    public void updateProject(Long projectId, Project project) {
    }

    public void deleteProjectById(Long projectId) {
        String hqlQuery = "delete from Project p where p.id= :id";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id",projectId);
        query.executeUpdate();
    }
}
