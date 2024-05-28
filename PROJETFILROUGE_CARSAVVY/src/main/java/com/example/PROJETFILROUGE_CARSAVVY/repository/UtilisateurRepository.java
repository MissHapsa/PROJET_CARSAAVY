package com.example.PROJETFILROUGE_CARSAVVY.repository;
import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {


    Optional<Utilisateur> findByEmail(String email);
}
