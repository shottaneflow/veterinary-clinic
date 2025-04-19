package org.example.veterinaryclinic.controller;


import org.example.veterinaryclinic.entity.VetUser;
import org.example.veterinaryclinic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/user-api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserInformation(@RequestBody VetUser vetUser,
                                                   Principal principal) {
        VetUser user=this.userService.findByUsername(principal.getName());
        if (!Objects.equals(vetUser.getEmail(), "")){
            user.setEmail(vetUser.getEmail());
        }
        if (!Objects.equals(vetUser.getPhoneNumber(), "")){
            user.setPhoneNumber(vetUser.getPhoneNumber());
        }
        if (!Objects.equals(vetUser.getFirstName(), "")){
            user.setFirstName(vetUser.getFirstName());
        }
        this.userService.updateUser(user);
        return ResponseEntity.ok(user);

    }
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Principal principal) {
        VetUser user=this.userService.findByUsername(principal.getName());
        return ResponseEntity.ok(user);
    }
}
