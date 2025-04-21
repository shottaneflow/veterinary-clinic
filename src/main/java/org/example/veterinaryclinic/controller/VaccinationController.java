package org.example.veterinaryclinic.controller;


import org.example.veterinaryclinic.entity.Animal;
import org.example.veterinaryclinic.entity.Vaccination;
import org.example.veterinaryclinic.service.AnimalService;
import org.example.veterinaryclinic.service.VaccinationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vaccination-api")
public class VaccinationController {

    private final VaccinationService vaccinationService;
    private final AnimalService animalService;

    public VaccinationController(VaccinationService vaccinationService,
                                 AnimalService animalService) {
        this.vaccinationService = vaccinationService;
        this.animalService = animalService;
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<?> getByAnimal(@PathVariable UUID animalId) {
        List<Vaccination> vaccinations=vaccinationService.findByAnimalId(animalId);
        return ResponseEntity.ok(vaccinations);
    }
    @PostMapping("/create/{animalId}")
    public ResponseEntity<?> create(@PathVariable UUID animalId,@RequestBody Vaccination vaccination) {
        Animal animal=this.animalService.getById(animalId);
        vaccination.setAnimal(animal);
        this.vaccinationService.addVaccination(vaccination);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Vaccination vaccination) {
        vaccination.setId(id);
        this.vaccinationService.updateVaccination(vaccination);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.vaccinationService.delete(id);
        return ResponseEntity.ok().build();
    }


}
