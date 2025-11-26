package com.tienda.tcg.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes()); // 🔥 CLAVE VÁLIDA
    }

    // ==========================================
    // 🔵 GENERAR TOKEN
    // ==========================================
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey, SignatureAlgorithm.HS256) // 🔥 FIRMA CORRECTA
                .compact();
    }

    // ==========================================
    // 🔵 EXTRAER USERNAME
    // ==========================================
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ==========================================
    // 🔵 EXTRAER ROLE
    // ==========================================
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ==========================================
    // 🔵 VALIDAR TOKEN
    // ==========================================
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ==========================================
    // 🔵 OBTENER CLAIMS
    // ==========================================
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)      // 🔥 NUEVO MÉTODO - CORRECTO
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
