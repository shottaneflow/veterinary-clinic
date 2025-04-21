package org.example.veterinaryclinic.repo;

import org.example.veterinaryclinic.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VaccinationRepo extends JpaRepository<Vaccination, UUID> {
    List<Vaccination> findVaccinationByAnimalId(UUID animalId);
}
