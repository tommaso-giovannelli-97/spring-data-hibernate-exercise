package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.Project;
import com.bitrock.springdataproject.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProjectService {
    @Autowired
    ProjectRepository repository;

    public Project create(Project project) {
        return repository.save(project);
    }

    public List<Project> findAll () {
        return repository.findAll();
    }

    public Project findById(Long projectId) {
        Optional<Project> optionalProject = repository.findById(projectId);
        return optionalProject.orElse(null);
    }

    public Project update(Long projectId, Project project) throws Exception {
        Optional<Project> optionalProject = repository.findById(projectId);
        if (optionalProject.isEmpty()) {
            throw new Exception("No existing Project with the given id");
        }
        return repository.save(project);
    }

    public void delete(Long projectId) {
        repository.deleteById(projectId);
    }
}
