package org.example.veterinaryclinic.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class VetVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate visitDate;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;

    public VetVisit() {
    }

    public String getId() {
        return this.id;
    }

    public LocalDate getVisitDate() {
        return this.visitDate;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public Vet getVet() {
        return this.vet;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof VetVisit)) return false;
        final VetVisit other = (VetVisit) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$visitDate = this.getVisitDate();
        final Object other$visitDate = other.getVisitDate();
        if (this$visitDate == null ? other$visitDate != null : !this$visitDate.equals(other$visitDate)) return false;
        final Object this$animal = this.getAnimal();
        final Object other$animal = other.getAnimal();
        if (this$animal == null ? other$animal != null : !this$animal.equals(other$animal)) return false;
        final Object this$vet = this.getVet();
        final Object other$vet = other.getVet();
        if (this$vet == null ? other$vet != null : !this$vet.equals(other$vet)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof VetVisit;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $visitDate = this.getVisitDate();
        result = result * PRIME + ($visitDate == null ? 43 : $visitDate.hashCode());
        final Object $animal = this.getAnimal();
        result = result * PRIME + ($animal == null ? 43 : $animal.hashCode());
        final Object $vet = this.getVet();
        result = result * PRIME + ($vet == null ? 43 : $vet.hashCode());
        return result;
    }

    public String toString() {
        return "VetVisit(id=" + this.getId() + ", visitDate=" + this.getVisitDate() + ", animal=" + this.getAnimal() + ", vet=" + this.getVet() + ")";
    }
}
