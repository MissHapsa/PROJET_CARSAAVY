package com.example.PROJETFILROUGE_CARSAVVY.model;


import com.example.PROJETFILROUGE_CARSAVVY.view.ReservationView;
import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurAvecCommandeView;
import com.example.PROJETFILROUGE_CARSAVVY.view.UtilisateurView;
import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class,ReservationView.class})
     protected String nom;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class,ReservationView.class})
    protected String prenom;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    protected String rue;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    protected Long cp;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    protected String tel;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    protected String ville;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    protected Date date_creation;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    @Column( unique = true)
    protected String email;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    protected String passeword;

    //@JsonView(UtilisateurView.class)
    //protected boolean administrateur;

    @ManyToOne
    protected Role role;

    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class})
    @OneToMany(mappedBy = "utilisateur")
    private List<Vehicule> vehicules;



    public String getPassword() {
        return passeword;
    }

    public void setPassword(String passeword) {
        this.passeword = passeword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public Date getDateCreation() {
        return date_creation;
    }

    public void setDateCreation(Date dateCreation) {
        this.date_creation = dateCreation;
    }
}

