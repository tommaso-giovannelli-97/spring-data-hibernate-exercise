package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Project;
import org.hibernate.Session;

public class ProjectService extends BaseDbService<Project> {

    public void updateProject(Long projectId, Project project) {
        Session session = getSession();
        Project oldProject = getById("Select p from Project p where p.id = :id", projectId);

        if(oldProject != null) {
            project.setId(projectId);
            session.update(project);
            session.flush(); //To make update work!
        }
        session.close();
    }
}
