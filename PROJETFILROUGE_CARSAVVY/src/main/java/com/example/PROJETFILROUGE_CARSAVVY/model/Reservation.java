package com.example.PROJETFILROUGE_CARSAVVY.model;

import com.example.PROJETFILROUGE_CARSAVVY.view.*;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JsonView({UtilisateurView.class, UtilisateurAvecCommandeView.class,ReservationView.class})
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView({VehiculeView.class, UtilisateurAvecCommandeView.class, UtilisateurView.class,ReservationView.class})
    @JoinColumn(name = "id_vehicule", nullable = false)
    private Vehicule vehicule;

    @ManyToOne
    @JsonView(ReservationView.class)
    @JoinColumn(name = "id_prestation", nullable = false)
    private Prestation prestation;

    @JsonView(ReservationView.class)
    @Column(name = "date_reservation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateReservation;

    @JsonView(ReservationView.class)
    @Column(name = "statut", nullable = false)
    private String statut;

    @JsonView(ReservationView.class)
    @Column(name = "creneau", nullable = false)
    private LocalTime creneau;
}
