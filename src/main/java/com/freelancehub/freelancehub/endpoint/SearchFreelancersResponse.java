package com.freelancehub.freelancehub.endpoint;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "searchFreelancersResponse",
        namespace = "http://freelancehub.com/users"
)
public class SearchFreelancersResponse {

    @XmlElement(namespace = "http://freelancehub.com/users")
    private List<FreelancerResult> freelancers;

    public SearchFreelancersResponse() {
    }

    public List<FreelancerResult> getFreelancers() {
        return freelancers;
    }

    public void setFreelancers(List<FreelancerResult> freelancers) {
        this.freelancers = freelancers;
    }
}