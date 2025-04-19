package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.VetUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    public VetUser findByUsername(String username);
    void addUser(VetUser user);
    void updateUser(VetUser user);
}
