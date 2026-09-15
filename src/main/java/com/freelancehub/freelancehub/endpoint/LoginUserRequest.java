package com.freelancehub.freelancehub.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "loginUserRequest",
        namespace = "http://freelancehub.com/users"
)
public class LoginUserRequest {

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String email;

    @XmlElement(namespace = "http://freelancehub.com/users")
    private String password;

    public LoginUserRequest() {
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
}