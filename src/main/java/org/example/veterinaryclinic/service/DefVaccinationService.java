package org.example.veterinaryclinic.service;


import org.example.veterinaryclinic.entity.Vaccination;
import org.example.veterinaryclinic.repo.VaccinationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefVaccinationService implements VaccinationService {

    private final VaccinationRepo vaccinationRepo;
    public DefVaccinationService(VaccinationRepo vaccinationRepo) {
        this.vaccinationRepo = vaccinationRepo;
    }

    @Override
    public List<Vaccination> findByAnimalId(UUID animalId) {
        return this.vaccinationRepo.findVaccinationByAnimalId(animalId);
    }

    @Override
    public void addVaccination(Vaccination vaccination) {
         this.vaccinationRepo.save(vaccination);
    }

    @Override
    public void updateVaccination(Vaccination vaccination) {
        this.vaccinationRepo.save(vaccination);
    }

    @Override
    public void delete(UUID id) {
        this.vaccinationRepo.deleteById(id);
    }
}
