package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;
import com.example.PROJETFILROUGE_CARSAVVY.repository.VehiculeRepository;
import com.example.PROJETFILROUGE_CARSAVVY.security.AppUserDetails;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurAvecCommandeView;
import com.example.PROJETFILROUGE_CARSAVVY.view.VehiculeView;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class VehiculeConctroller {
    @Autowired
    VehiculeRepository vehiculeRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/vehicule/liste")
    @JsonView(VehiculeView.class)
    public List<Vehicule> getAllVehicules() {

        return vehiculeRepository.findAll();
    }

    @GetMapping("/utilisateur-vehicule/liste")
    @JsonView({VehiculeView.class, UtilisateurAvecCommandeView.class})
    public List<Vehicule> getAllVehicules(@AuthenticationPrincipal AppUserDetails user) {

        return vehiculeRepository.findAllByIdUtilisateur(user.getUtilisateur().getId());
    }

    @PostMapping("/vehicule")
    @JsonView(VehiculeView.class)
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule, @AuthenticationPrincipal AppUserDetails user) {
        vehicule.setIdutilisateur(user.getUtilisateur());
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return new ResponseEntity<>(savedVehicule, HttpStatus.CREATED);
    }

}

