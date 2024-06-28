package com.project.Hackathon.repository;

import com.project.Hackathon.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DeveloperRepository extends JpaRepository<Developer, Long>{
    List<Developer> findByName(String name);
}

