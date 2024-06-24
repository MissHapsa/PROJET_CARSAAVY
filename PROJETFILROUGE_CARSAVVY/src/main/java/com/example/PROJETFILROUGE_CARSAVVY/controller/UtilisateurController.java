package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import com.example.PROJETFILROUGE_CARSAVVY.repository.UtilisateurRepository;
import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurAvecCommandeView;
import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurView;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateur/liste")
    @JsonView(UtilisateurView.class)
    public List<Utilisateur> liste() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> get(@PathVariable int id) {  // Ajout du paramètre id

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

        if(utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/utilisateur")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> add(@Valid @RequestBody Utilisateur nouveauUtilisateur) {

        // C'est une mise à jour
        if(nouveauUtilisateur.getId() != null) {

            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(nouveauUtilisateur.getId());

            // l'utilisateur tente de modifier un utilisateur qui n'existe pas/plus
            if(utilisateurOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            utilisateurRepository.save(nouveauUtilisateur);

            return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
        }

        utilisateurRepository.save(nouveauUtilisateur);

        return new ResponseEntity<>(nouveauUtilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> update(@RequestBody Utilisateur utilisateurAmodifier, @PathVariable int id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

        // L'utilisateur tente de modifier un utilisateur qui n'existe pas/plus
        if (utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Utilisateur utilisateurExistant = utilisateurOptional.get();

        // Conserver le mot de passe et le rôle existants
        utilisateurAmodifier.setPassword(utilisateurExistant.getPassword());
        utilisateurAmodifier.setRole(utilisateurExistant.getRole());
        utilisateurAmodifier.setDateCreation(utilisateurExistant.getDateCreation());

        // Mettre à jour les autres champs
        utilisateurAmodifier.setId(id);

        utilisateurRepository.save(utilisateurAmodifier);
        return new ResponseEntity<>(utilisateurAmodifier, HttpStatus.OK);
    }

    @DeleteMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> delete (@PathVariable int id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

        if(utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        utilisateurRepository.deleteById(id);

        return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
    }
}
