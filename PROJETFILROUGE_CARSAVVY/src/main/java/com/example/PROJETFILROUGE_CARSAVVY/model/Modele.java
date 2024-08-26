package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.*;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.Session;

@Getter
@Setter
@Entity
@Table(name = "modele")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @JsonView({ModeleView.class, UtilisateurAvecCommandeView.class, UtilisateurView.class,VenteView.class, VehiculeView.class})
    @Column(nullable = false, length = 100)
    protected String nom;

    @JsonView(ModeleView.class)
    @Column(nullable = false, length = 100)
    protected String annee;


@ManyToOne
@JoinColumn(name = "id_marque")
@JsonView({MarqueView.class, UtilisateurAvecCommandeView.class,UtilisateurView.class, VenteView.class, VehiculeView.class})
protected Marque marque;





}
