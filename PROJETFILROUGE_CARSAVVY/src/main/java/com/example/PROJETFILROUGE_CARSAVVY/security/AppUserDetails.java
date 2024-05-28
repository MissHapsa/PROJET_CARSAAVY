package com.example.PROJETFILROUGE_CARSAVVY.security;

import com.example.PROJETFILROUGE_CARSAVVY.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {

    protected Utilisateur utilisateur;

    public AppUserDetails(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

//        return List.of(new SimpleGrantedAuthority(utilisateur.isAdministrateur() ? "ROLE_ADMIN" : "ROLE_USER"));
//
//
        return List.of(new SimpleGrantedAuthority(utilisateur.getRole().getNom()));
    }

    @Override
    public String getPassword() {
        return utilisateur.getPasseword();
    }

    @Override
    public String getUsername() {
        return utilisateur.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
