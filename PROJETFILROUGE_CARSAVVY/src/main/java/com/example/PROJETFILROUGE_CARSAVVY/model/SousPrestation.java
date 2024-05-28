package com.example.PROJETFILROUGE_CARSAVVY.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name = "sousprestation")
public class SousPrestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, length = 100)
    protected String libelle;

    @Column(nullable = false, length = 100)
    protected int prix;

    @Column(nullable = false, length = 100)
    protected Time duree;

    @ManyToOne
    @JoinColumn(name = "id_prestation")
    protected Prestation prestation;


}