package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.Vaccination;
import org.example.veterinaryclinic.entity.VetVisit;

import java.util.List;
import java.util.UUID;

public interface VisitService {
    List<VetVisit> getVisitByAnimalId(UUID animalId);
    void save(VetVisit visit);
    void deleteVisit(UUID id);
}
