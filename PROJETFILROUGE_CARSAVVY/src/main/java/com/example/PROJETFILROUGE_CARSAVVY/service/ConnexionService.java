package com.example.PROJETFILROUGE_CARSAVVY.service;

public interface ConnexionService {
    public boolean isConnected(
            String username,
            String password

    );

    public void connect(String username, String password);

}
