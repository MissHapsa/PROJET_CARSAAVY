package com.example.PROJETFILROUGE_CARSAVVY.service;
import com.example.PROJETFILROUGE_CARSAVVY.repository.VenteRepository;
import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;

import java.util.ArrayList;
import java.util.List;

public interface VenteService {
    List<Vehicule> getAllVente();

    Vehicule getVehiculeById(int id);

    void addVehicule(Vehicule vehicule);

    void deleteVehicule(Vehicule vehicule);

    void updateVehicule(Vehicule vehicule);

}