package com.freelancehub.freelancehub.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "searchFreelancersRequest",
        namespace = "http://freelancehub.com/users"
)
public class SearchFreelancersRequest {

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String skill;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private int minExperience;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private double minRating;

    public SearchFreelancersRequest() {
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(int minExperience) {
        this.minExperience = minExperience;
    }

    public double getMinRating() {
        return minRating;
    }

    public void setMinRating(double minRating) {
        this.minRating = minRating;
    }
}