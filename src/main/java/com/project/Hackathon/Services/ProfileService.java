package com.project.Hackathon.Services;

import com.project.Hackathon.Entity.Profile;
import com.project.Hackathon.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public List<Profile> getProfilesByName(String name) {
        return profileRepository.findByName(name);
    }

    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
        profile.setName(profileDetails.getName());
        profile.setSurname(profileDetails.getSurname());
        profile.setSkills(profileDetails.getSkills());
        profile.setExperience(profileDetails.getExperience());
        profile.setProfilePhoto(profileDetails.getProfilePhoto());
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}