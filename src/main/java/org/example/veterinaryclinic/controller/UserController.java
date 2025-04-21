package org.example.veterinaryclinic.controller;


import org.example.veterinaryclinic.entity.Vet;
import org.example.veterinaryclinic.entity.VetUser;
import org.example.veterinaryclinic.service.UserService;
import org.example.veterinaryclinic.service.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user-api")
public class UserController {

    private final UserService userService;
    private final VetService vetService;

    public UserController(UserService userService, VetService vetService) {
        this.userService = userService;
        this.vetService = vetService;
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
    @GetMapping("/get-doctors")
    public ResponseEntity<?> getDoctors(){
        List<Vet> vets=this.vetService.getVets();
        return ResponseEntity.ok().body(vets);
    }

}
