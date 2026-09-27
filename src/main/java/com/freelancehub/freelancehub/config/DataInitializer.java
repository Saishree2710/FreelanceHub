package com.freelancehub.freelancehub.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.freelancehub.freelancehub.model.Project;
import com.freelancehub.freelancehub.repository.ProjectRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeProjects(ProjectRepository projectRepository) {

        return args -> {

            // Add sample projects only if the table is empty
            if (projectRepository.count() == 0) {

                projectRepository.save(
                        new Project(
                                "Build a React Portfolio Website",
                                "Create a modern and responsive portfolio website for a software developer.",
                                "React, JavaScript, HTML, CSS",
                                5000
                        )
                );

                projectRepository.save(
                        new Project(
                                "Develop a Spring Boot REST API",
                                "Build a backend REST API with Spring Boot, JPA and MySQL.",
                                "Java, Spring Boot, REST API, MySQL",
                                8000
                        )
                );

                projectRepository.save(
                        new Project(
                                "Design a Business Landing Page",
                                "Create a professional responsive landing page for a small business.",
                                "HTML, CSS, JavaScript, UI/UX",
                                3500
                        )
                );

                projectRepository.save(
                        new Project(
                                "Python Data Analysis Project",
                                "Analyze a business dataset and generate meaningful visualizations and insights.",
                                "Python, Pandas, NumPy, Matplotlib",
                                6000
                        )
                );

                System.out.println(
                        "Sample projects inserted successfully."
                );
            }
        };
    }
}