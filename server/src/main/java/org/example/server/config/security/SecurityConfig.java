package org.example.server.config.security;

import lombok.AllArgsConstructor;
import org.example.server.config.jwt.JwtAuthenticationEntryPoint;
import org.example.server.config.jwt.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity // Active la sécurité au niveau de l'application
@EnableMethodSecurity // Active la sécurité au niveau des méthodes
@AllArgsConstructor // Génère un constructeur avec des arguments pour chaque champ final
public class SpringSecurityConfig {

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JwtRequestFilter jwtRequestFilter;

    // Bean pour encoder les mots de passe
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configure la chaîne de filtres de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        configure(http); // Appel de la méthode configure
        return http.build(); // Construit la configuration de sécurité
    }

    // Méthode pour configurer la sécurité
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Désactive la protection CSRF car JWT est utilisé
                .authorizeHttpRequests(authz -> authz // Configure l'autorisation des requêtes HTTP
                        // Permet l'accès non authentifié à ces endpoints
                        .requestMatchers("/api/auth/register", "/api/auth/login", "/notices", "/contact").permitAll()
                        // Accès aux endpoints pour Citizen
                        .requestMatchers(HttpMethod.GET, "/citizens/**").hasRole("CITIZEN") // Citizen peut accéder à ses propres données
                        .requestMatchers(HttpMethod.POST, "/citizens/**").hasRole("CITIZEN") // Citizen peut créer ses données

                        // Accès aux endpoints pour Station
                        .requestMatchers(HttpMethod.GET, "/stations/**").hasAnyRole("CITIZEN", "ADMIN") // Accès en lecture pour Citizen et ADMIN
                        .requestMatchers(HttpMethod.POST, "/stations/**").hasRole("ADMIN") // Créer une station uniquement pour ADMIN

                        // Accès aux endpoints pour TransportLine
                        .requestMatchers(HttpMethod.GET, "/transportLines/**").hasAnyRole("CITIZEN", "ADMIN") // Accès en lecture pour Citizen et ADMIN
                        .requestMatchers(HttpMethod.POST, "/transportLines/**").hasRole("ADMIN") // Créer une ligne de transport uniquement pour ADMIN

                        // Accès aux endpoints pour TransportType
                        .requestMatchers(HttpMethod.GET, "/transportTypes/**").hasAnyRole("CITIZEN", "ADMIN") // Accès en lecture pour Citizen et ADMIN
                        .requestMatchers(HttpMethod.POST, "/transportTypes/**").hasRole("ADMIN") // Créer un type de transport uniquement pour ADMIN

                        // Accès aux endpoints pour Notification
                        .requestMatchers(HttpMethod.GET, "/notifications/**").hasAnyRole("CITIZEN", "ADMIN") // Accès en lecture pour Citizen et ADMIN
                        .requestMatchers(HttpMethod.POST, "/notifications/**").hasRole("ADMIN") // Créer une notification uniquement pour ADMIN

                        // Accès aux endpoints pour Schedule
                        .requestMatchers(HttpMethod.GET, "/schedules/**").hasAnyRole("CITIZEN", "ADMIN") // Accès en lecture pour Citizen et ADMIN
                        .requestMatchers(HttpMethod.POST, "/schedules/**").hasRole("ADMIN") // Créer un horaire uniquement pour ADMIN

                        // Toute autre requête nécessite une authentification
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception
                        .jwtAuthenticationEntryPoint(jwtAuthenticationEntryPoint)) // Gère les exceptions d'authentification
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Ajoute le filtre JWT
    }

    // Bean pour obtenir le AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // Configuration CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000")); // Permettre l'origine locale
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); // Permet toutes les méthodes
        configuration.setAllowedHeaders(Arrays.asList("*")); // Permet tous les headers
        configuration.setAllowCredentials(true); // Autoriser les cookies, l'autorisation, etc.

        // Appliquer cette configuration à tous les chemins
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
