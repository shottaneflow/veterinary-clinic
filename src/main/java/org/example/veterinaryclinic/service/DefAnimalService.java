package org.example.veterinaryclinic.service;


import org.example.veterinaryclinic.entity.Animal;
import org.example.veterinaryclinic.repo.AnimalRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefAnimalService implements AnimalService {

    private final AnimalRepo animalRepo;
    public DefAnimalService(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public void save(Animal animal) {
        this.animalRepo.save(animal);
    }

    @Override
    public void deleteAnimal(UUID id) {
        this.animalRepo.deleteById(id);
    }

    @Override
    public List<Animal> getAll() {
        return this.animalRepo.findAll();
    }

    @Override
    public Animal getById(UUID id) {
        return this.animalRepo.findById(id).orElse(null);
    }

    @Override
    public List<Animal> findByUserId(String userId) {
        return this.animalRepo.findByVetUser_Id(userId);
    }
}
