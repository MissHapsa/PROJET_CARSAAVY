package com.example.PROJETFILROUGE_CARSAVVY.service;

import com.example.PROJETFILROUGE_CARSAVVY.model.Salarie;

import java.util.List;

public interface SalarieService {
    List<Salarie> getAllSalaries(


    );


    Salarie getSalarieById(int id);

    void addSalarie(Salarie salarie);

    void updateSalarie(Salarie salarie);
}
