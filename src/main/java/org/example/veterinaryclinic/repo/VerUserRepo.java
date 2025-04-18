package org.example.veterinaryclinic.repo;

import org.example.veterinaryclinic.entity.VetUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerUserRepo extends JpaRepository<VetUser, UUID> {
    Optional<VetUser> findByUsername(String username);

}
