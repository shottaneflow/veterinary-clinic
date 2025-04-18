package org.example.veterinaryclinic.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Animal> pets;

    public Owner() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public List<Animal> getPets() {
        return this.pets;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPets(List<Animal> pets) {
        this.pets = pets;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Owner)) return false;
        final Owner other = (Owner) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$pets = this.getPets();
        final Object other$pets = other.getPets();
        if (this$pets == null ? other$pets != null : !this$pets.equals(other$pets)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Owner;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $pets = this.getPets();
        result = result * PRIME + ($pets == null ? 43 : $pets.hashCode());
        return result;
    }

    public String toString() {
        return "Owner(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", pets=" + this.getPets() + ")";
    }
}
