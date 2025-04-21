package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.Animal;

import java.util.List;
import java.util.UUID;

public interface AnimalService {
    void save(Animal animal);
    void deleteAnimal(UUID id);
    List<Animal> getAll();
    Animal getById(UUID id);
    List<Animal> findByUserId(String userId);
}
