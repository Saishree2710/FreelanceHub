package com.freelancehub.freelancehub.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "registerUserRequest",
        namespace = "http://freelancehub.com/users"
)
public class RegisterUserRequest {

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String name;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String email;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String password;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String role;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String skills;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private int experience;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private double rating;

    public RegisterUserRequest() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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