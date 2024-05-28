package com.example.PROJETFILROUGE_CARSAVVY.controller;


import com.example.PROJETFILROUGE_CARSAVVY.model.Role;
import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import com.example.PROJETFILROUGE_CARSAVVY.repository.RoleRepository;
import com.example.PROJETFILROUGE_CARSAVVY.repository.UtilisateurRepository;
import com.example.PROJETFILROUGE_CARSAVVY.security.AppUserDetails;
import com.example.PROJETFILROUGE_CARSAVVY.security.JwtUtils;
import com.fasterxml.jackson.annotation.JsonView;
import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ConnexionController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/connexion")
    public ResponseEntity<Map<String, Object>> connexion(@RequestBody Utilisateur utilisateur) {

        try {
            UserDetails userDetails = (UserDetails) authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getEmail(),
                            utilisateur.getPasseword())).getPrincipal();

            return new ResponseEntity<>(Map.of("jwt",jwtUtils.generateToken(userDetails)), HttpStatus.OK);

        } catch (AuthenticationException ex) {

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        }
    }

    @PostMapping("/inscription")
    public ResponseEntity<Map<String, Object>> inscription (@RequestBody Utilisateur utilisateur) {

        utilisateur.setPasseword(bCryptPasswordEncoder.encode(utilisateur.getPasseword()));
        // Créer une instance de Role avec l'identifiant du rôle à attribuer à l'utilisateur
        Role roleUtilisateur = new Role(); // par exemple, en utilisant l'identifiant du rôle

        roleUtilisateur.setId(3);

        // Assigner le rôle récupéré à l'utilisateur
        utilisateur.setRole(roleUtilisateur);
        utilisateurRepository.save(utilisateur);

        return new ResponseEntity<>(Map.of("message","utilisateur créé"), HttpStatus.CREATED);

    }

    @GetMapping("/profil")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> profil (@AuthenticationPrincipal AppUserDetails userDetails){

        Utilisateur user = userDetails.getUtilisateur();
        //user.setListeCommandes(null);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }



}
