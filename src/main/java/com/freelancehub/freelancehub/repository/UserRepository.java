package com.freelancehub.freelancehub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.freelancehub.freelancehub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("""
            SELECT u
            FROM User u
            WHERE UPPER(u.role) = 'FREELANCER'
            AND (:skill = '' OR LOWER(u.skills) LIKE LOWER(CONCAT('%', :skill, '%')))
            AND u.experience >= :minExperience
            AND u.rating >= :minRating
            ORDER BY u.rating DESC
            """)
    List<User> searchFreelancers(
            @Param("skill") String skill,
            @Param("minExperience") int minExperience,
            @Param("minRating") double minRating
    );
}