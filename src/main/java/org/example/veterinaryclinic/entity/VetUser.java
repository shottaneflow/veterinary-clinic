package org.example.veterinaryclinic.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class VetUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    @ManyToMany
    @JoinTable(name = "t_user_authority",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_authority"))
    private List<Authority> authorities;

    public VetUser() {
        this.authorities = new ArrayList<>();
    }

    public void addAuthorities(Authority authority) {
        this.authorities.add(authority);
    }

    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Authority> getAuthorities() {
        return this.authorities;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof VetUser)) return false;
        final VetUser other = (VetUser) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$authorities = this.getAuthorities();
        final Object other$authorities = other.getAuthorities();
        if (this$authorities == null ? other$authorities != null : !this$authorities.equals(other$authorities))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof VetUser;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $authorities = this.getAuthorities();
        result = result * PRIME + ($authorities == null ? 43 : $authorities.hashCode());
        return result;
    }

    public String toString() {
        return "VetUser(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", authorities=" + this.getAuthorities() + ")";
    }
}
