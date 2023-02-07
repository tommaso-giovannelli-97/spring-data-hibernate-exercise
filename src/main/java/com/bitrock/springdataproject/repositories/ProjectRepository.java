package com.bitrock.springdataproject.repositories;

import com.bitrock.springdataproject.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
