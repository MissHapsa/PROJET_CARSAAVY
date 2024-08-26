package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Modele;
import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;
import com.example.PROJETFILROUGE_CARSAVVY.repository.ModeleRepository;
import com.example.PROJETFILROUGE_CARSAVVY.repository.VehiculeRepository;
import com.example.PROJETFILROUGE_CARSAVVY.repository.VenteRepository;
import com.example.PROJETFILROUGE_CARSAVVY.security.AppUserDetails;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.*;
import com.fasterxml.jackson.annotation.JsonView;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

public class VehiculeConctroller {
    @Autowired
    VehiculeRepository vehiculeRepository;

//    importation du Venterepository pour autoriser la suppression d un vehicule sans pb de clé etrangere
    @Autowired
    private VenteRepository venteRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/vehicule/liste")
    @JsonView(VehiculeView.class)
    public List<Vehicule> getAllVehicules() {

        return vehiculeRepository.findAll();
    }


    @GetMapping("/vehicule/{id}")
    @JsonView(VehiculeView.class)
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isPresent()) {
            return new ResponseEntity<>(vehicule.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/vehicule")
//    @JsonView(VehiculeView.class)
//    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule, @AuthenticationPrincipal AppUserDetails utilisateur) {
//        if (utilisateur == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//
//        if (utilisateur.getUtilisateur() == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//
//        vehicule.setIdutilisateur(utilisateur.getUtilisateur());
//        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
//        return new ResponseEntity<>(savedVehicule, HttpStatus.CREATED);
//    }



    @Transactional
    @DeleteMapping("/vehicule/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        if (vehiculeRepository.existsById(id)) {
            venteRepository.deleteByVehiculeId(id);  // Supprimer les références dans la table vente
            vehiculeRepository.deleteById(id);       // Supprimer le véhicule
            System.out.println("Véhicule supprimé avec succès.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            System.out.println("Échec de la suppression : Véhicule non trouvé.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

