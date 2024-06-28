package com.project.Hackathon.repository;

import com.project.Hackathon.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface developerRepository extends JpaRepository<Profile,Long> {

    List<Profile> findByName(String name);
}
