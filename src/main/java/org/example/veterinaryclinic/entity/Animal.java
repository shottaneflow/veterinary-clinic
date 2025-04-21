package org.example.veterinaryclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String type;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VetVisit> vetVisits;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"animals"})
    private VetUser vetUser;

    public Animal() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public List<Vaccination> getVaccinations() {
        return this.vaccinations;
    }

    public List<VetVisit> getVetVisits() {
        return this.vetVisits;
    }

    public VetUser getVetUser() {
        return this.vetUser;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public void setVetVisits(List<VetVisit> vetVisits) {
        this.vetVisits = vetVisits;
    }

    public void setVetUser(VetUser vetUser) {
        this.vetUser = vetUser;
    }
}
