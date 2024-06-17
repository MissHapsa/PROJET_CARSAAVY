package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.MarqueView;
import com.example.PROJETFILROUGE_CARSAVVY.view.PrestationView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "marque")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, length = 100)
    @JsonView(MarqueView.class)
    protected String nom;

}
