package com.freelancehub.freelancehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancehub.freelancehub.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findByFreelancerId(Long freelancerId);
}