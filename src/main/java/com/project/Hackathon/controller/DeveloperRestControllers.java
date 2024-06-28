package com.project.Hackathon.controller;

import com.project.Hackathon.entity.Developer;
import com.project.Hackathon.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/developers")
public class DeveloperRestControllers {
    @Autowired
    private DeveloperRepository developerRepository;

    @PostMapping
    public ResponseEntity<?> addDeveloper(@RequestBody Developer developer) {
        return new ResponseEntity<>(developerRepository.save(developer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Developer>> getAllDevelopers() {
        return new ResponseEntity<>(developerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperWithId(@PathVariable Long id) {
        Developer developer = developerRepository.findById(id).orElse(null);
        if (developer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(developer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloperFromDB(@PathVariable("id") long id, @RequestBody Developer developer) {
        Optional<Developer> currentDeveloperOpt = developerRepository.findById(id);
        Developer currentDeveloper = currentDeveloperOpt.get();
        currentDeveloper.setName(developer.getName());
        currentDeveloper.setLastname(developer.getLastname());
        currentDeveloper.setSkills(developer.getSkills());
        return new ResponseEntity<>(developerRepository.save(currentDeveloper), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloperWithId(@PathVariable Long id) {
        developerRepository.deleteById(id);
    }
}
