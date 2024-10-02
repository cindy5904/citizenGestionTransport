package org.example.server.config.jwt;

import org.example.server.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Value("${jwt.secret}")
    private String secret;

    // Convertit la clé secrète en format utilisable par l'algorithme de signature
    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Authentication auth) {
        String username = auth.getName();

        // Extraire les rôles (autorités) de l'objet Authentication
        String roles = auth.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.joining(","));

        // Obtenir l'ID à partir de l'entité Admin
        Long id = ((Admin) auth.getPrincipal()).getId();

        System.out.println("id " + id);

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + 86400000); // 24 heures

        // Créer le token avec des revendications personnalisées
        String token = Jwts.builder()
                .setSubject(username)
                .claim("roles", roles) // Ajouter les rôles comme revendication personnalisée
                .claim("userid", id)    // Ajouter l'ID de l'admin
                .claim("adminPrivileges", true) // Si l'admin a des privilèges spécifiques
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();

        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true; // Le token est valide
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
