package com.example.PROJETFILROUGE_CARSAVVY.repository;

import com.example.PROJETFILROUGE_CARSAVVY.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Utilise la méthode findAll() fournie par JpaRepository, inutile de la redéfinir

    @Query("FROM Reservation r JOIN FETCH r.utilisateur u WHERE u.id = :idUtilisateur")
    List<Reservation> findAllByIdUtilisateur(@Param("idUtilisateur") Long idUtilisateur);

    @Query("FROM Reservation r JOIN FETCH r.vehicule v WHERE v.id = :idVehicule")
    List<Reservation> findAllByIdVehicule(@Param("idVehicule") Long idVehicule);
    boolean existsById(Long id);

    void deleteById(Long id);

    Optional<Reservation> findById(Long id);

}
