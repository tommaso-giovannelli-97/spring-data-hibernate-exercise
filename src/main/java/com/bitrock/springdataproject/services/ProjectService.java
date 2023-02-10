package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Project;
import com.bitrock.springdataproject.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends BaseDbService<Project> {
    public ProjectService(ProjectRepository repository) {
        super(repository);
    }
}
