package org.example.veterinaryclinic.repo;

import org.example.veterinaryclinic.entity.VetVisit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VetVisitRepo extends JpaRepository<VetVisit, UUID> {
    List<VetVisit> findVetVisitByAnimalId(UUID vetId);

}
