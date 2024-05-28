package com.example.PROJETFILROUGE_CARSAVVY.model;


import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView({UtilisateurView.class})
     protected String nom;

    @JsonView({UtilisateurView.class})
    protected String prenom;

    @JsonView({UtilisateurView.class})
    protected String rue;

    @JsonView({UtilisateurView.class})
    protected Long cp;

    @JsonView({UtilisateurView.class})
    protected String tel;

    @JsonView({UtilisateurView.class})
    protected String ville;

    @JsonView({UtilisateurView.class})
    protected Date date_creation;

    @JsonView({UtilisateurView.class})
    @Column( unique = true)
    protected String email;

    @JsonView({UtilisateurView.class})
    protected String passeword;

    //@JsonView(UtilisateurView.class)
    //protected boolean administrateur;

    @ManyToOne
    protected Role role;



}

