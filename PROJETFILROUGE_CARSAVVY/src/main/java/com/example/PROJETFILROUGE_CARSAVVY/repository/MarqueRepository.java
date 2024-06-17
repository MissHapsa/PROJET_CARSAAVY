package com.example.PROJETFILROUGE_CARSAVVY.repository;

import com.example.PROJETFILROUGE_CARSAVVY.model.Marque;
import com.example.PROJETFILROUGE_CARSAVVY.model.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long > {
}
