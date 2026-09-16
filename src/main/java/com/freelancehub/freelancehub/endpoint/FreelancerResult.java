package com.freelancehub.freelancehub.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class FreelancerResult {

    @XmlElement(namespace = "http://freelancehub.com/users")
    private Long id;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String name;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String email;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String skills;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private int experience;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private double rating;

    public FreelancerResult() {
    }

    public FreelancerResult(
            Long id,
            String name,
            String email,
            String skills,
            int experience,
            double rating) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.experience = experience;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}