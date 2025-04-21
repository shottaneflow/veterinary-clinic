package org.example.veterinaryclinic.controller;

import org.example.veterinaryclinic.entity.Animal;
import org.example.veterinaryclinic.entity.Vaccination;
import org.example.veterinaryclinic.entity.Vet;
import org.example.veterinaryclinic.entity.VetVisit;
import org.example.veterinaryclinic.service.AnimalService;
import org.example.veterinaryclinic.service.VetService;
import org.example.veterinaryclinic.service.VisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/visit-api")
public class VisitController {

    private final VisitService visitService;
    private final AnimalService animalService;
    private final VetService vetService;

    public VisitController(VisitService visitService,
                           AnimalService animalService,
                           VetService vetService) {
        this.visitService = visitService;
        this.animalService = animalService;
        this.vetService = vetService;
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<?> getVisits(@PathVariable("animalId") UUID animalId) {
        List<VetVisit> visits=this.visitService.getVisitByAnimalId(animalId);
        return ResponseEntity.ok(visits);
    }
    @PostMapping("/create/{animalId}/{doctorId}")
    public ResponseEntity<?> createVisit(@PathVariable("animalId") UUID animalId,
                                         @PathVariable("doctorId") UUID doctorId,
                                         @RequestBody VetVisit visit) {
        Animal animal=this.animalService.getById(animalId);
        Vet vet=this.vetService.getVetById(doctorId);
        visit.setAnimal(animal);
        visit.setVet(vet);
        this.visitService.save(visit);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVisit(@PathVariable("id") UUID id, @RequestBody VetVisit visit) {
        visit.setId(id);
        this.visitService.save(visit);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVisit(@PathVariable("id") UUID id) {
        this.visitService.deleteVisit(id);
        return ResponseEntity.ok().build();
    }
}
