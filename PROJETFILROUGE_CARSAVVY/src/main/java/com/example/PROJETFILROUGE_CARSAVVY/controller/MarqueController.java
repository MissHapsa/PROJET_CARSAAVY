package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Marque;
import com.example.PROJETFILROUGE_CARSAVVY.repository.MarqueRepository;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.MarqueView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MarqueController {

    @Autowired
    MarqueRepository marqueRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/marque/liste")
    @JsonView (MarqueView.class)
    public List<Marque> getAllMarque() {

        return marqueRepository.findAll();

    }

}
