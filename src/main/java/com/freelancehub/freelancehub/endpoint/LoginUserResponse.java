package com.freelancehub.freelancehub.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "loginUserResponse",
        namespace = "http://freelancehub.com/users"
)
public class LoginUserResponse {

    @XmlElement(namespace = "http://freelancehub.com/users")
    private boolean success;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private Long id;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String name;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String email;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String role;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String message;

    public LoginUserResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}