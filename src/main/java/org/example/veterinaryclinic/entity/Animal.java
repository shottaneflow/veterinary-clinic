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
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

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

    public Owner getOwner() {
        return this.owner;
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

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Animal)) return false;
        final Animal other = (Animal) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$dateOfBirth = this.getDateOfBirth();
        final Object other$dateOfBirth = other.getDateOfBirth();
        if (this$dateOfBirth == null ? other$dateOfBirth != null : !this$dateOfBirth.equals(other$dateOfBirth))
            return false;
        final Object this$vaccinations = this.getVaccinations();
        final Object other$vaccinations = other.getVaccinations();
        if (this$vaccinations == null ? other$vaccinations != null : !this$vaccinations.equals(other$vaccinations))
            return false;
        final Object this$owner = this.getOwner();
        final Object other$owner = other.getOwner();
        if (this$owner == null ? other$owner != null : !this$owner.equals(other$owner)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Animal;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $dateOfBirth = this.getDateOfBirth();
        result = result * PRIME + ($dateOfBirth == null ? 43 : $dateOfBirth.hashCode());
        final Object $vaccinations = this.getVaccinations();
        result = result * PRIME + ($vaccinations == null ? 43 : $vaccinations.hashCode());
        final Object $owner = this.getOwner();
        result = result * PRIME + ($owner == null ? 43 : $owner.hashCode());
        return result;
    }

    public String toString() {
        return "Animal(id=" + this.getId() + ", type=" + this.getType() + ", dateOfBirth=" + this.getDateOfBirth() + ", vaccinations=" + this.getVaccinations() + ", owner=" + this.getOwner() + ")";
    }
}
