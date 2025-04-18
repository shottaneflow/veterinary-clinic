package org.example.veterinaryclinic.repo;

import org.example.veterinaryclinic.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VetRepo extends JpaRepository<Vet, UUID> {

}
