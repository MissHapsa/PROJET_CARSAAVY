package com.example.PROJETFILROUGE_CARSAVVY.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "garage")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, length = 100)
    protected String nom;

    @Column(nullable = false, length = 100)
    protected String rue;

    @Column(nullable = false, length = 100)
    protected Integer cp;

    @Column(nullable = false, length = 100)
    protected String ville;

    @Column(nullable = false, length = 100)
    protected Integer tel;

    @Column(nullable = false, length = 100)
    protected String email;

    @Column(nullable = false, length = 100)
    protected String site_web;


}

