package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.PrestationView;
import com.example.PROJETFILROUGE_CARSAVVY.view.VenteView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "prestation")
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @JsonView(PrestationView.class)
    @Column(nullable = false, length = 100)
    protected String libelle;

    @JsonView (PrestationView.class)
    @Column(columnDefinition = "TEXT")
    protected String description;

    @JsonView (PrestationView.class)
    @Column(columnDefinition = "TEXT")
    protected String imageUrl;

    @JsonView (PrestationView.class)
   @ManyToOne
   @JoinColumn(name = "id_garage")
    protected Garage garage;

    @JsonView (PrestationView.class)
    @Column(nullable = false, length = 100)
    protected int duree;


}
