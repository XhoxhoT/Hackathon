package com.project.Hackathon.Controllers;

import com.project.Hackathon.Entity.Profile;
import com.project.Hackathon.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("customProfileController")
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Get all profiles
    @GetMapping("/all")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    // Get profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
        return ResponseEntity.ok(profile);
    }

    // Add new profile
    @PostMapping
    public Profile addProfile(@RequestBody Profile profile) {
        return profileService.addProfile(profile);
    }

    // Update profile
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
        Profile updatedProfile = profileService.updateProfile(id, profileDetails);
        return ResponseEntity.ok(updatedProfile);
    }

    // Delete profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}