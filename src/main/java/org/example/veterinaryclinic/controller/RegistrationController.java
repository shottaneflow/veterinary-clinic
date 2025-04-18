package org.example.veterinaryclinic.controller;


import org.example.veterinaryclinic.entity.VetUser;
import org.example.veterinaryclinic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reg-api")
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody VetUser user) {
        try {
            this.userService.addUser(user);
            return ResponseEntity.ok().build();
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
