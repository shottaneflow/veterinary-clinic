package org.example.veterinaryclinic.controller;


import org.example.veterinaryclinic.entity.Animal;
import org.example.veterinaryclinic.entity.VetUser;
import org.example.veterinaryclinic.service.AnimalService;
import org.example.veterinaryclinic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animal-api")
public class AnimalController {

    private final AnimalService animalService;
    private final UserService userService;
    public AnimalController(AnimalService animalService,
                            UserService userService) {
        this.animalService = animalService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAnimal(@RequestBody Animal animal,
                                          Authentication authentication) {
        animal.setVetUser(userService.findByUsername(authentication.getName()));
        this.animalService.save(animal);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable UUID id, @RequestBody Animal animal) {
        Animal fromDb=this.animalService.getById(id);
        fromDb.setDateOfBirth(animal.getDateOfBirth());
        fromDb.setType(animal.getType());
        this.animalService.save(fromDb);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable UUID id) {
        this.animalService.deleteAnimal(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Animal>> getUserAnimals(Authentication authentication) {
        VetUser user = userService.findByUsername(authentication.getName());
        List<Animal> animals = animalService.findByUserId(user.getId());
        return ResponseEntity.ok(animals);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable UUID id) {
        Animal animal=this.animalService.getById(id);
        return ResponseEntity.ok().body(animal);
    }


}
