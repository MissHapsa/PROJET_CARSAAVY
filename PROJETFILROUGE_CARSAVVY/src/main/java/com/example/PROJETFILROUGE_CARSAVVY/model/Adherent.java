package com.example.PROJETFILROUGE_CARSAVVY.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "adherent")
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(nullable = false, length = 100)
    protected Integer id_utilisateur;
    @Column(nullable = false, length = 100)
    protected Date date_debut;
    @Column( length = 100)
    protected Date date_fin;





}