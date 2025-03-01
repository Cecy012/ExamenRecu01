package com.superheros.ingrid.security;


import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
    private final String SECRET_KEY = "D/l9MK1jdt1TpHf8wHSKgjIyRVdf5+fBrRClbg0XE++7FTijEZ3BSGvpmBvYvzWz4eA/qYBmg8ImRK7W1B/usQ=="; // Cambiar por tu clave secreta
    private final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos




    @SuppressWarnings("deprecation")
    public String generateToken(String username){
        return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();
    }

    public boolean validateToken(String token) {
        try {
             // Decodifica la clave secreta en Base64
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
            Jwts.parserBuilder()
                .setSigningKey(decodedKey)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
      public Claims getClaimsFromToken(String token) {
         // Decodifica la clave secreta en Base64
    byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
        return Jwts.parserBuilder()
                .setSigningKey(decodedKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
