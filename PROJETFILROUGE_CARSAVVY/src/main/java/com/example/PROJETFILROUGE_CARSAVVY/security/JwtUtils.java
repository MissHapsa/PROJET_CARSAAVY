package com.example.PROJETFILROUGE_CARSAVVY.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${secret.jwt}")
    private String secret;
    Date now = new Date();
    private long jwtExpirationMs;
    Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
    


    public String getSubjectFromJwt(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("JWT mal formé ou signature invalide", e);
        }
    }

    public boolean validateJwt(String token, UserDetails userDetails) {
        String username = getSubjectFromJwt(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration().before(new Date());
    }

    public String generateToken(UserDetails userDetails) {

        AppUserDetails appUserDetails = (AppUserDetails) userDetails;

        Map<String, Object> claims = new HashMap<>();
        String token = doGenerateToken(claims, userDetails.getUsername());

        claims.put("id", appUserDetails.utilisateur.getId());
        claims.put("nom", appUserDetails.utilisateur.getNom());
        claims.put("prenom", appUserDetails.utilisateur.getPrenom());
        claims.put("rue", appUserDetails.utilisateur.getRue());
        claims.put("cp", appUserDetails.utilisateur.getCp());
        claims.put("ville", appUserDetails.utilisateur.getVille());
        claims.put("email", appUserDetails.utilisateur.getEmail());
        claims.put("tel", appUserDetails.utilisateur.getTel());
        claims.put("role", appUserDetails.utilisateur.getRole());
        System.out.println("Generated JWT: " + token);  // Log the generated JWT

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String doGenerateToken(Map<String, Object> claims, String username) {
        long expirationTime = 1000 * 60 * 60; // 1 heure
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
