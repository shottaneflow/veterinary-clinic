package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.Vet;
import org.example.veterinaryclinic.repo.VetRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefVetService implements VetService {

    private final VetRepo vetRepo;
    public DefVetService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }
    @Override
    public void addVet(Vet vet) {
        this.vetRepo.save(vet);
    }

    @Override
    public List<Vet> getVets() {
        return this.vetRepo.findAll();
    }

    @Override
    public void updateVet(Vet vet) {
        this.vetRepo.save(vet);
    }

    @Override
    public void deleteVet(UUID id) {
        this.vetRepo.deleteById(id);
    }

    @Override
    public Vet getVetById(UUID id) {
        return this.vetRepo.findById(id).orElse(null);
    }
}
