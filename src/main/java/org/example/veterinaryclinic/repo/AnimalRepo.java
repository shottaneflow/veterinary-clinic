package org.example.veterinaryclinic.repo;

import org.example.veterinaryclinic.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalRepo extends JpaRepository<Animal, UUID> {
    List<Animal> findByVetUser_Id(String userId);
}
