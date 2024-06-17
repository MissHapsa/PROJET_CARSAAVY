package com.example.PROJETFILROUGE_CARSAVVY.repository;

import com.example.PROJETFILROUGE_CARSAVVY.model.Materiel;
import com.example.PROJETFILROUGE_CARSAVVY.model.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long > {

}
