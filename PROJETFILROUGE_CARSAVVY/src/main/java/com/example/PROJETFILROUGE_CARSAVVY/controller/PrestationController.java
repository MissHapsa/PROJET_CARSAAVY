package com.example.PROJETFILROUGE_CARSAVVY.controller;
import com.example.PROJETFILROUGE_CARSAVVY.model.Prestation;
import com.example.PROJETFILROUGE_CARSAVVY.repository.PrestationRepository;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.PrestationView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class PrestationController {

    @Autowired
    PrestationRepository prestationRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/prestation/liste")
    @JsonView (PrestationView.class)
    public List<Prestation> getAllPrestation() {

        return prestationRepository.findAll();

    }

}
