package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.*;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

import java.util.Optional;

@Getter
@Setter
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({VehiculeView.class, UtilisateurAvecCommandeView.class,UtilisateurView.class})
    protected Integer id;

    @JsonView({VehiculeView.class, UtilisateurAvecCommandeView.class,UtilisateurView.class})
    private int annee;

    @JsonView({VehiculeView.class, UtilisateurAvecCommandeView.class,UtilisateurView.class, ReservationView.class})
    private String immat;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView({VehiculeView.class, UtilisateurAvecCommandeView.class,UtilisateurView.class, VenteView.class})
    @JoinColumn(name = "id_modele", referencedColumnName = "id")
    private Modele modele;

    public void setIdutilisateur(Utilisateur utilisateur) {
    }
}
