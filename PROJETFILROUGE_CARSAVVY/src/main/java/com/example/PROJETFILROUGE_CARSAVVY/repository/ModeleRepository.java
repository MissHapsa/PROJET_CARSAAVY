package com.example.PROJETFILROUGE_CARSAVVY.repository;

import com.example.PROJETFILROUGE_CARSAVVY.model.Marque;
import com.example.PROJETFILROUGE_CARSAVVY.model.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, Long > {
}
