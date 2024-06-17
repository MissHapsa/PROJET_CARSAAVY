package com.example.PROJETFILROUGE_CARSAVVY.service;

import com.example.PROJETFILROUGE_CARSAVVY.model.Vehicule;

import java.util.List;

public interface VehiculeService {
    List<Vehicule> getAllVehicules();


    Vehicule getVehiculeById(int id);

    void addVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Long id, Vehicule vehicule);

    Vehicule createVehicule(Vehicule vehicule);

    void deleteVehicule(Long id);
}
