package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.Vaccination;
import org.example.veterinaryclinic.entity.VetVisit;
import org.example.veterinaryclinic.repo.VaccinationRepo;
import org.example.veterinaryclinic.repo.VetVisitRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefVisitService implements VisitService {

    private final VetVisitRepo visitRepo;
    public DefVisitService(VetVisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public List<VetVisit> getVisitByAnimalId(UUID animalId) {
        return this.visitRepo.findVetVisitByAnimalId(animalId);
    }

    @Override
    public void save(VetVisit visit) {
        this.visitRepo.save(visit);
    }

    @Override
    public void deleteVisit(UUID id) {
        this.visitRepo.deleteById(id);
    }
}
