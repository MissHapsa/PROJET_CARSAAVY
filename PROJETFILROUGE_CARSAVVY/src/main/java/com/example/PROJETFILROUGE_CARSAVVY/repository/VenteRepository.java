package com.example.PROJETFILROUGE_CARSAVVY.repository;


import com.example.PROJETFILROUGE_CARSAVVY.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Long> {
    void deleteByVehiculeId(Long vehiculeId);


}
