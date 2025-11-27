package com.petly.backend.repository;

import com.petly.backend.model.SitterProfile;
import com.petly.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SitterProfileRepository extends JpaRepository<SitterProfile, Long> {

    Optional<SitterProfile> findByUser(User user);

    Optional<SitterProfile> findByUserId(Long userId);
}
