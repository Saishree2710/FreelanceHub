package com.freelancehub.freelancehub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.freelancehub.freelancehub.model.User;
import com.freelancehub.freelancehub.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> loginUser(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() &&
                user.get().getPassword().equals(password)) {

            return user;
        }

        return Optional.empty();
    }


    // =========================
    // SEARCH FREELANCERS
    // =========================

    public List<User> searchFreelancers(
            String skill,
            int minExperience,
            double minRating) {

        return userRepository.searchFreelancers(
                skill,
                minExperience,
                minRating
        );
    }
}