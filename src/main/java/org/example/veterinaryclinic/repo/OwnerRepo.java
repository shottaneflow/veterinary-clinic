package org.example.veterinaryclinic.repo;

import org.example.veterinaryclinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepo extends JpaRepository<Owner, UUID> {
}
