package org.example.veterinaryclinic.controller;

import org.example.veterinaryclinic.entity.Vet;
import org.example.veterinaryclinic.service.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin-api")
public class AdminController {
    private final VetService vetService;
    public AdminController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping("/create-doctor")
    public ResponseEntity<?> createDoctor(@RequestBody Vet vet){
        this.vetService.addVet(vet);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-doctors")
    public ResponseEntity<?> getDoctors(){
        List<Vet> vets=this.vetService.getVets();
        return ResponseEntity.ok().body(vets);
    }
    @PutMapping("/update-doctor/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable UUID id, @RequestBody Vet vet) {
        vet.setId(id);
        this.vetService.updateVet(vet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-doctor/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable UUID id) {
        this.vetService.deleteVet(id);
        return ResponseEntity.ok().build();
    }

}
