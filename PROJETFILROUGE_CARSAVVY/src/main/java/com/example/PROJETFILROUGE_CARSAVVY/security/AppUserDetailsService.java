package com.example.PROJETFILROUGE_CARSAVVY.security;

import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import com.example.PROJETFILROUGE_CARSAVVY.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Utilisateur> optionalClient = clientRepository.findByEmail(email);

        if(optionalClient.isPresent()) {

            return new AppUserDetails(optionalClient.get());
        }

        throw new UsernameNotFoundException("Email introuvable");
    }

}
