package com.example.PROJETFILROUGE_CARSAVVY.controller;

import com.example.PROJETFILROUGE_CARSAVVY.model.Prestation;
import com.example.PROJETFILROUGE_CARSAVVY.model.Reservation;
import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;
import com.example.PROJETFILROUGE_CARSAVVY.repository.PrestationRepository;
import com.example.PROJETFILROUGE_CARSAVVY.repository.ReservationRepository;
import com.example.PROJETFILROUGE_CARSAVVY.repository.UtilisateurRepository;
import com.example.PROJETFILROUGE_CARSAVVY.repository.VehiculeRepository;
import com.example.PROJETFILROUGE_CARSAVVY.service.FichierService;
import com.example.PROJETFILROUGE_CARSAVVY.view.ReservationView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private PrestationRepository prestationRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private FichierService fichierService;

    // Get all reservations
    @GetMapping("/liste")
    @JsonView(ReservationView.class)
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Get a reservation by ID
    @GetMapping("/{id}")
    @JsonView(ReservationView.class)
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get reservations by user ID
    @GetMapping("/utilisateur/{idUtilisateur}")
    @JsonView(ReservationView.class)
    public List<Reservation> getReservationsByUserId(@PathVariable Long idUtilisateur) {
        return reservationRepository.findAllByIdUtilisateur(idUtilisateur);
    }

    // Get reservations by vehicle ID
    @GetMapping("/vehicule/{idVehicule}")
    @JsonView(ReservationView.class)
    public List<Reservation> getReservationsByVehicleId(@PathVariable Long idVehicule) {
        return reservationRepository.findAllByIdVehicule(idVehicule);
    }

    // Create a new reservation
    @PostMapping("/utilisateur/{idUtilisateur}")
    public ResponseEntity<Reservation> createReservation(@PathVariable("idUtilisateur") Long idUtilisateur, @RequestBody Reservation reservation) {
        if (reservation.getUtilisateur() == null || reservation.getUtilisateur().getId() == null) {
            throw new IllegalArgumentException("L'ID de l'utilisateur ne doit pas être nul");
        }
        if (reservation.getVehicule() == null || reservation.getVehicule().getId() == null) {
            throw new IllegalArgumentException("L'ID du véhicule ne doit pas être nul");
        }
        if (reservation.getPrestation() == null || reservation.getPrestation().getId() == null) {
            throw new IllegalArgumentException("L'ID de la prestation ne doit pas être nul");
        }
        Vehicule vehicule = vehiculeRepository.findById(reservation.getVehicule().getId())
                .orElseThrow(() -> new RuntimeException("Véhicule non trouvé"));

        // Sauvegarder la réservation
        Reservation newReservation = reservationRepository.save(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }


    // Update a reservation
    @PutMapping("/{id}")
    @JsonView(ReservationView.class)
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservation.setUtilisateur(reservationDetails.getUtilisateur());
            reservation.setVehicule(reservationDetails.getVehicule());
            reservation.setPrestation(reservationDetails.getPrestation());
            reservation.setDateReservation(reservationDetails.getDateReservation());
            reservation.setStatut(reservationDetails.getStatut());
            Reservation updatedReservation = reservationRepository.save(reservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
