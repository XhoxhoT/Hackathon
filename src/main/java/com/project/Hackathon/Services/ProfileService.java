package com.project.Hackathon.Services;

import com.project.Hackathon.Entity.Profile;
import com.project.Hackathon.repository.developerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private developerRepository developerRepository;

    public List<Profile> getAllProfiles() {
        return developerRepository.findAll();
    }

    public List<Profile> getProfilesByName(String name) {
        return developerRepository.findByName(name);
    }

    public Profile addProfile(Profile profile) {
        return developerRepository.save(profile);
    }

    public Optional<Profile> getProfileById(Long id) {
        return developerRepository.findById(id);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile profile = developerRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
        profile.setName(profileDetails.getName());
        profile.setSurname(profileDetails.getSurname());
        profile.setSkills(profileDetails.getSkills());
        profile.setExperience(profileDetails.getExperience());
        profile.setProfilePhoto(profileDetails.getProfilePhoto());
        return developerRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        developerRepository.deleteById(id);
    }
}