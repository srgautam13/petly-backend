package com.petly.backend.repository;

import com.petly.backend.model.SitterProfile;
import com.petly.backend.model.SitterService;
import com.petly.backend.model.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SitterServiceRepository extends JpaRepository<SitterService, Long> {

    List<SitterService> findBySitterProfile(SitterProfile sitterProfile);

    List<SitterService> findBySitterProfileId(Long sitterProfileId);

    List<SitterService> findByServiceType(ServiceType serviceType);
}
