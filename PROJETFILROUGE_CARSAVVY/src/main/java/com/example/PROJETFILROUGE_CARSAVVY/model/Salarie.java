package com.example.PROJETFILROUGE_CARSAVVY.model;
import com.example.PROJETFILROUGE_CARSAVVY.view.SalarieView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "salaries")
public class Salarie  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String nom;

    protected String prenom;

    @JsonView({SalarieView.class})
    @Column( unique = true)

    protected String passeword;

    protected String email;

    @Column(nullable = false, length = 100)
    protected String poste;


@ManyToOne
@JoinColumn(name = "id_garage")
protected Garage garage;

}