package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Marque;
import com.example.PROJETFILROUGE_CARSAVVY.model.Modele;
import com.example.PROJETFILROUGE_CARSAVVY.repository.ModeleRepository;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.ModeleView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
public class ModeleController {

    @Autowired
    ModeleRepository modeleRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/modele/liste")
    @JsonView(ModeleView.class)
    public List<Modele> getAllModele() {
        return modeleRepository.findAll();

    }

}
