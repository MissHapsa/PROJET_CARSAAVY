package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.MaterielView;
import com.example.PROJETFILROUGE_CARSAVVY.view.PrestationView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "materiel")
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @JsonView(MaterielView.class)
    @Column(nullable = false, length = 100)
    protected String nom;

}