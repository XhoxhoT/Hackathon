package com.project.Hackathon.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @ElementCollection
    @CollectionTable(name = "profile_skills", joinColumns = @JoinColumn(name = "developer_id"))
    @Column(name = "skill")
    private List<String> skills;

    @Column(name = "experience", nullable = false)
    private int experience;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "dev_project",
            joinColumns = @JoinColumn(name = "dev_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<ProjectHistory> projectHistories;

    // Getters and setters

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Set<ProjectHistory> getProjectHistories() {
        return projectHistories;
    }

    public void setProjectHistories(Set<ProjectHistory> projectHistories) {
        this.projectHistories = projectHistories;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "developerId=" + developerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", skills=" + skills +
                ", experience=" + experience +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", projectHistories=" + projectHistories +
                '}';
    }
}
