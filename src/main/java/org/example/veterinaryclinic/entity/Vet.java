package org.example.veterinaryclinic.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity
public class Vet {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private String email;

    public Vet() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Vet)) return false;
        final Vet other = (Vet) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$fullName = this.getFullName();
        final Object other$fullName = other.getFullName();
        if (this$fullName == null ? other$fullName != null : !this$fullName.equals(other$fullName)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Vet;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $fullName = this.getFullName();
        result = result * PRIME + ($fullName == null ? 43 : $fullName.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        return result;
    }

    public String toString() {
        return "Vet(id=" + this.getId() + ", fullName=" + this.getFullName() + ", phoneNumber=" + this.getPhoneNumber() + ", email=" + this.getEmail() + ")";
    }
}
