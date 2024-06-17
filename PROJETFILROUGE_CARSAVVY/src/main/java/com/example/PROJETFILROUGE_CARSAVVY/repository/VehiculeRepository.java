package com.example.PROJETFILROUGE_CARSAVVY.repository;

import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
    List<Vehicule> findAll();

    @Query("FROM Vehicule v JOIN FETCH v.utilisateur u WHERE u.id = :idUtilisateur ")
    List<Vehicule> findAllByIdUtilisateur(@Param("idUtilisateur") int idUtilisateur);
      
}
