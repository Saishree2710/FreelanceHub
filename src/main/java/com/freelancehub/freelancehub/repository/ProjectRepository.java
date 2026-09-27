package com.freelancehub.freelancehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancehub.freelancehub.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}