package org.example.veterinaryclinic.service;

import org.example.veterinaryclinic.entity.VetUser;
import org.example.veterinaryclinic.repo.VerUserRepo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.example.veterinaryclinic.entity.Authority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DefUserService implements UserService {

    private final VerUserRepo verUserRepo;
    private final PasswordEncoder passwordEncoder;
    public DefUserService(VerUserRepo verUserRepo,
                          PasswordEncoder passwordEncoder) {
        this.verUserRepo = verUserRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username)  {
        VetUser user=this.verUserRepo.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Пользователь"+username+" не найден"));
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities().stream()
                        .map(Authority::getAuthority)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));

    }

    @Override
    public void addUser(VetUser user) {
        VetUser vetUser=this.verUserRepo.findByUsername(user.getUsername())
                .orElse(null);
        if (vetUser!=null){
            throw new BadCredentialsException("Пользователь уже существует");
        }
        Authority auth = new Authority();
        auth.setId(2);
        auth.setAuthority("ROLE_USER");
        user.addAuthorities(auth);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.verUserRepo.save(user);
    }
}
