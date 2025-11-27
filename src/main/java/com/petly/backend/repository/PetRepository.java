package com.petly.backend.repository;

import com.petly.backend.model.Pet;
import com.petly.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByOwner(User owner);

    List<Pet> findByOwnerId(Long ownerId);
}
