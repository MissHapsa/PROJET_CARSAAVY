package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Marque;
import com.example.PROJETFILROUGE_CARSAVVY.repository.MarqueRepository;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.MarqueView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MarqueController {

    @Autowired
    MarqueRepository marqueRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/marque")
    @JsonView (MarqueView.class)
    public List<Marque> getAllMarque() {

        return marqueRepository.findAll();

    }

    @GetMapping("/marque/{id}")
    public ResponseEntity<Marque> get(@PathVariable long id) {

        Optional<Marque> MarqueOptional = marqueRepository.findById(id);

        if(MarqueOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(MarqueOptional.get(),HttpStatus.OK);
    }

}
