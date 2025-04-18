package org.example.veterinaryclinic.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private LocalDate date;

    private String name;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    public Vaccination() {
    }

    public UUID getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Vaccination)) return false;
        final Vaccination other = (Vaccination) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$animal = this.getAnimal();
        final Object other$animal = other.getAnimal();
        if (this$animal == null ? other$animal != null : !this$animal.equals(other$animal)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Vaccination;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $animal = this.getAnimal();
        result = result * PRIME + ($animal == null ? 43 : $animal.hashCode());
        return result;
    }

    public String toString() {
        return "Vaccination(id=" + this.getId() + ", date=" + this.getDate() + ", name=" + this.getName() + ", animal=" + this.getAnimal() + ")";
    }
}
