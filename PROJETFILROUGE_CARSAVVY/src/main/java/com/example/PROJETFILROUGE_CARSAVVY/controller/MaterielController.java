package com.example.PROJETFILROUGE_CARSAVVY.controller;
import com.example.PROJETFILROUGE_CARSAVVY.model.Materiel;
import com.example.PROJETFILROUGE_CARSAVVY.repository.MaterielRepository;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.MaterielView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class MaterielController {

    @Autowired
    MaterielRepository materielRepository;

    @Autowired
    FichierService fichierService;

    @GetMapping("/materiel/liste")
    @JsonView (MaterielView.class)
    public List<Materiel> getAllMateriel() {

        return materielRepository.findAll();

    }
}
