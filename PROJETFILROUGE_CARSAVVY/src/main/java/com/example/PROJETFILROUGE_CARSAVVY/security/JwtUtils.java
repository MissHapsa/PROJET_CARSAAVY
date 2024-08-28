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

    @Value("${jwt.expiration.ms}")
    private long jwtExpirationMs; // Configurez cela dans application.properties/yml

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
        claims.put("id", appUserDetails.getUtilisateur().getId());
        claims.put("nom", appUserDetails.getUtilisateur().getNom());
        claims.put("prenom", appUserDetails.getUtilisateur().getPrenom());
        claims.put("rue", appUserDetails.getUtilisateur().getRue());
        claims.put("cp", appUserDetails.getUtilisateur().getCp());
        claims.put("ville", appUserDetails.getUtilisateur().getVille());
        claims.put("email", appUserDetails.getUtilisateur().getEmail());
        claims.put("tel", appUserDetails.getUtilisateur().getTel());
        claims.put("role", appUserDetails.getUtilisateur().getRole());
        claims.put("role_id", appUserDetails.getUtilisateur().getRole().getId());

        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
