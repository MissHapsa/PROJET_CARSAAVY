package com.example.PROJETFILROUGE_CARSAVVY.service;

import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> getAllClients(


    );


    Utilisateur getClientById(int id);

    void addClient(Utilisateur utilisateur);

    void updateClient(Utilisateur utilisateur);
}
