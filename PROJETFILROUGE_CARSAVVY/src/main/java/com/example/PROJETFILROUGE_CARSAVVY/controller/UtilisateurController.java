package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import com.example.PROJETFILROUGE_CARSAVVY.repository.UtilisateurRepository;
import com.example.PROJETFILROUGE_CARSAVVY.security.IsUser;
import com.example.PROJETFILROUGE_CARSAVVY.security.IsAdmin;
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
    @JsonView(UtilisateurAvecCommandeView.class)
    public ResponseEntity<Utilisateur> get(@PathVariable int id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

        if(utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(utilisateurOptional.get(),HttpStatus.OK);
    }


    @PostMapping("/utilisateur")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> add(@Valid @RequestBody Utilisateur nouveauUtilisateur) {

        //C'est une mise à jour
        if(nouveauUtilisateur.getId() != null) {

            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(nouveauUtilisateur.getId());

            //l'utilisateur tente de modifier un utilisateur qui n'existe pas/plus
            if(utilisateurOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            utilisateurRepository.save(nouveauUtilisateur);

            return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
        }

        utilisateurRepository.save(nouveauUtilisateur);

        return new ResponseEntity<>(nouveauUtilisateur, HttpStatus.CREATED);
    }

//    @PostMapping("/utilisateur")
//    public ResponseEntity<Utilisateur> add (@RequestBody Utilisateur nouveauUtilisateur) {
//        nouveauUtilisateur.setId(null);
//        utilisateurDao.save(nouveauUtilisateur);
//        return new ResponseEntity<>(nouveauUtilisateur, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/utilisateur/{id}")
//    public ResponseEntity<Utilisateur> update (@RequestBody Utilisateur utilisateurAmodifier, @PathVariable int id) {
//        utilisateurAmodifier.setId(id);
//
//        Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(utilisateurAmodifier.getId());
//
//        //l'utilisateur tente de modifier un utilisateur qui n'existe pas/plus
//        if(utilisateurOptional.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        utilisateurDao.save(utilisateurAmodifier);
//        return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
//    }

    @DeleteMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> delete (@PathVariable int id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);

        if(utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        utilisateurRepository.deleteById(id);

        return new ResponseEntity<>(utilisateurOptional.get(),HttpStatus.OK);
    }
}