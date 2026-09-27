package com.freelancehub.freelancehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancehub.freelancehub.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByFreelancerId(Long freelancerId);

    boolean existsByProjectIdAndFreelancerId(Long projectId, Long freelancerId);
}