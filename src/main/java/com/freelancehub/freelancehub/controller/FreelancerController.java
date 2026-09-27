package com.freelancehub.freelancehub.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancehub.freelancehub.model.Application;
import com.freelancehub.freelancehub.model.Project;
import com.freelancehub.freelancehub.model.Service;
import com.freelancehub.freelancehub.repository.ApplicationRepository;
import com.freelancehub.freelancehub.repository.ProjectRepository;
import com.freelancehub.freelancehub.repository.ServiceRepository;
import com.freelancehub.freelancehub.repository.UserRepository;

@RestController
@RequestMapping("/api/freelancer")
public class FreelancerController {

    private final ProjectRepository projectRepository;
    private final ApplicationRepository applicationRepository;
    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;

    public FreelancerController(
            ProjectRepository projectRepository,
            ApplicationRepository applicationRepository,
            ServiceRepository serviceRepository,
            UserRepository userRepository) {

        this.projectRepository = projectRepository;
        this.applicationRepository = applicationRepository;
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
    }


    // =========================
    // FIND PROJECTS
    // =========================

    @GetMapping("/projects")
    public List<Project> getProjects() {

        return projectRepository.findAll();
    }


    // =========================
    // APPLY FOR PROJECT
    // =========================

    @PostMapping("/applications")
    public ResponseEntity<?> applyForProject(
            @RequestBody Application application) {

        boolean alreadyApplied =
                applicationRepository
                        .existsByProjectIdAndFreelancerId(
                                application.getProjectId(),
                                application.getFreelancerId()
                        );

        if (alreadyApplied) {

            return ResponseEntity
                    .badRequest()
                    .body("You have already applied for this project.");
        }

        application.setStatus("PENDING");

        Application savedApplication =
                applicationRepository.save(application);

        return ResponseEntity.ok(savedApplication);
    }


    // =========================
    // MY APPLICATIONS
    // =========================

    @GetMapping("/applications/{freelancerId}")
    public List<Application> getMyApplications(
            @PathVariable Long freelancerId) {

        return applicationRepository
                .findByFreelancerId(freelancerId);
    }


    // =========================
    // MY PROFILE
    // =========================

    @GetMapping("/profile/{freelancerId}")
    public ResponseEntity<?> getProfile(
            @PathVariable Long freelancerId) {

        return userRepository
                .findById(freelancerId)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }


    // =========================
    // MY SERVICES
    // =========================

    @GetMapping("/services/{freelancerId}")
    public List<Service> getMyServices(
            @PathVariable Long freelancerId) {

        return serviceRepository
                .findByFreelancerId(freelancerId);
    }


    // =========================
    // ADD SERVICE
    // =========================

    @PostMapping("/services")
    public Service addService(
            @RequestBody Service service) {

        return serviceRepository.save(service);
    }


    // =========================
    // DELETE SERVICE
    // =========================

    @DeleteMapping("/services/{serviceId}")
    public ResponseEntity<?> deleteService(
            @PathVariable Long serviceId) {

        if (!serviceRepository.existsById(serviceId)) {

            return ResponseEntity
                    .notFound()
                    .build();
        }

        serviceRepository.deleteById(serviceId);

        return ResponseEntity.ok(
                "Service deleted successfully."
        );
    }
}