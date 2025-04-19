package org.example.veterinaryclinic.entity;

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
    private List<Vaccination> vaccinations;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private VetUser vetUser;

    public Animal() {
    }








}
