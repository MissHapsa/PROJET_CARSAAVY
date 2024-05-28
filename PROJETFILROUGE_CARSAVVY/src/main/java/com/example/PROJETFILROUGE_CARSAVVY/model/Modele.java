package com.example.PROJETFILROUGE_CARSAVVY.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "modele")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, length = 100)
    protected String nom;
    @Column(nullable = false, length = 100)
    protected String annee;
@ManyToOne
@JoinColumn(name = "id_marque")
protected Marque marque;




}
