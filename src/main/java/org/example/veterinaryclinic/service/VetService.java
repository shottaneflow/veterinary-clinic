package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.Vet;

import java.util.List;
import java.util.UUID;

public interface VetService {
    void addVet(Vet vet);
    List<Vet> getVets();
    void updateVet(Vet vet);
    void deleteVet(UUID id);
}
