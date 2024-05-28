package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurView;
import com.example.PROJETFILROUGE_CARSAVVY.view.VehiculeView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicule {
    @Id
    private Integer id;

    @JsonView({VehiculeView.class})
    private int annee;

    @JsonView({VehiculeView.class})
    private String immat;

    @ManyToOne
    @JsonView({VehiculeView.class})
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView({VehiculeView.class})
    @JoinColumn(name = "id_modele")
    private Modele modele;

}
