package com.example.PROJETFILROUGE_CARSAVVY.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtils {

    @Value("${secret.jwt}")
    private String secretJwt;

    public String generateToken(UserDetails userDetails) {

        AppUserDetails appUserDetails = (AppUserDetails) userDetails;

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", appUserDetails.utilisateur.getId());
        claims.put("nom", appUserDetails.utilisateur.getNom());
        claims.put("prenom", appUserDetails.utilisateur.getPrenom());
        claims.put("rue", appUserDetails.utilisateur.getRue());
        claims.put("cp", appUserDetails.utilisateur.getCp());
        claims.put("ville", appUserDetails.utilisateur.getVille());
        claims.put("email", appUserDetails.utilisateur.getEmail());
        claims.put("tel", appUserDetails.utilisateur.getTel());
        claims.put("role", appUserDetails.utilisateur.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256, secretJwt)
                .compact();
    }

    public String getSubjectFromJwt(String jwt) {
        try {
            // Vérifiez que le JWT contient exactement deux points (.) pour s'assurer qu'il est bien formé
            if (jwt == null || jwt.split("\\.").length != 3) {
                throw new IllegalArgumentException("JWT mal formé : il doit contenir exactement 2 caractères point (.).");
            }

            return Jwts.parser()
                    .setSigningKey(secretJwt)
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            System.err.println("Erreur lors de l'analyse du JWT : " + e.getMessage());
            return null;
        }
    }
}
