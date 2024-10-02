package org.example.server.config.jwt;

import org.example.server.service.AdminService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    // Injection de JwtTokenProvider pour la manipulation des tokens JWT
    @Autowired
    private JwtTokenProvider tokenGenerator;

    // AdminService est utilisé pour charger les détails de l'admin à partir de l'email
    private final AdminService adminService;  // Utilise AdminService au lieu de UserService

    // JwtAuthenticationEntryPoint est utilisé pour gérer les exceptions d'authentification
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    // Constructeur pour injecter AdminService
    public JwtRequestFilter(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // Extraire le JWT de la requête HTTP
            String token = getJWTFromRequest(request);

            // Vérifier si le token est non nul et valide
            if (token != null && tokenGenerator.validateToken(token)) {
                // Extraire l'email (username) de l'admin depuis le token
                String email = tokenGenerator.getUsernameFromToken(token);

                // Charger les détails de l'admin à partir de l'email
                UserDetails adminDetails = adminService.loadAdminByUsername(email);

                // Créer un token d'authentification avec les détails de l'admin
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        adminDetails, null, adminDetails.getAuthorities());

                // Associer des détails supplémentaires au token d'authentification
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Définir le token d'authentification dans le contexte de sécurité
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            // Continuer la chaîne de filtres
            filterChain.doFilter(request, response);
        } catch (AuthenticationException e) {
            // Gérer les exceptions d'authentification
            jwtAuthenticationEntryPoint.commence(request, response, e);

            // Point d'insertion pour le logging des erreurs d'authentification
            // Vous pouvez ajouter un log ici pour tracer l'erreur
        }
    }

    private String getJWTFromRequest(HttpServletRequest request) {
        // Extrait le token JWT de l'en-tête "Authorization" de la requête
        String bearerToken = request.getHeader("Authorization");
        // Vérifie si le token est non null et commence bien par "Bearer "
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            // Extraire le token JWT sans le préfixe "Bearer "
            return bearerToken.substring(7);
        }
        return null; // Retourner null si le token n'est pas présent ou mal formaté
    }
}
