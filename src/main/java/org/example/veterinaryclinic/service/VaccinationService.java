package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.Vaccination;

import java.util.List;
import java.util.UUID;

public interface VaccinationService {
    List<Vaccination> findByAnimalId(UUID animalId);
    void addVaccination(Vaccination vaccination);
    void updateVaccination(Vaccination vaccination);
    void delete(UUID id);
}
