package com.example.PROJETFILROUGE_CARSAVVY.controller;


import com.example.PROJETFILROUGE_CARSAVVY.model.Vente;
import com.example.PROJETFILROUGE_CARSAVVY.repository.VenteRepository;
import com.example.PROJETFILROUGE_CARSAVVY.security.IsAdmin;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.VenteView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class VenteController {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/vente/liste")
    @JsonView (VenteView.class)
    public List<Vente> getAllVente() {

        return venteRepository.findAll();

    }

    @GetMapping("/vente/{id}")
    public ResponseEntity<Vente> get(@PathVariable long id) {

        Optional<Vente> venteOptional = venteRepository.findById(id);

        if(venteOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(venteOptional.get(),HttpStatus.OK);
    }


    @PostMapping("/vente")
    @IsAdmin
    public ResponseEntity<Vente> add(@Valid @RequestBody Vente nouveauVente) {

        //C'est une mise à jour
        if(nouveauVente.getId() != null) {

            Optional<Vente> venteOptional = venteRepository.findById(nouveauVente.getId());

            //l'utilisateur tente de modifier un voitureOccasion qui n'existe pas/plus
            if(venteOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            venteRepository.save(nouveauVente);

            return new ResponseEntity<>(venteOptional.get(), HttpStatus.OK);
        }

        venteRepository.save(nouveauVente);

        return new ResponseEntity<>(nouveauVente, HttpStatus.CREATED);
    }


    @DeleteMapping("/vente/{id}")
    public ResponseEntity<Vente> delete (@PathVariable long id) {

        Optional<Vente> venteOptional = venteRepository.findById(id);

        if(venteOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        venteRepository.deleteById(id);

        return new ResponseEntity<>(venteOptional.get(),HttpStatus.OK);
    }
}