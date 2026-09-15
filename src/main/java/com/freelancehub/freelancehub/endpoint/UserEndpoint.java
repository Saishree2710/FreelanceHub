package com.freelancehub.freelancehub.endpoint;

import java.util.Optional;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.freelancehub.freelancehub.model.User;
import com.freelancehub.freelancehub.service.UserService;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE =
            "http://freelancehub.com/users";

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "registerUserRequest"
    )
    @ResponsePayload
    public RegisterUserResponse registerUser(
            @RequestPayload RegisterUserRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setSkills(request.getSkills());
        user.setExperience(request.getExperience());
        user.setRating(request.getRating());

        User savedUser = userService.registerUser(user);

        RegisterUserResponse response =
                new RegisterUserResponse();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());
        response.setMessage("User registered successfully");

        return response;
    }


    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "loginUserRequest"
    )
    @ResponsePayload
    public LoginUserResponse loginUser(
            @RequestPayload LoginUserRequest request) {

        Optional<User> user =
                userService.loginUser(
                        request.getEmail(),
                        request.getPassword()
                );

        LoginUserResponse response =
                new LoginUserResponse();

        if (user.isPresent()) {

            User loggedInUser = user.get();

            response.setSuccess(true);
            response.setId(loggedInUser.getId());
            response.setName(loggedInUser.getName());
            response.setEmail(loggedInUser.getEmail());
            response.setRole(loggedInUser.getRole());
            response.setMessage("Login successful");

        } else {

            response.setSuccess(false);
            response.setMessage("Invalid email or password");
        }

        return response;
    }
}