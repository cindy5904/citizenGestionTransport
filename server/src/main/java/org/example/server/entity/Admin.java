package org.example.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    private boolean isEnabled=true;

    @JsonIgnore
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;


    // Si on veut gérer les rôles plus tard, on peut ajouter une collection ici.
    // Pour l'instant, on retourne une collection vide.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Retourne une liste vide pour le moment.
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email; // Utilise l'email comme identifiant.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Le compte n'est pas expiré.
    }

    @Override
    public boolean isAccountNonLocked() {
        return  true; // Le compte n'est pas verrouillé.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Les informations d'identification ne sont pas expirées.
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled; // Retourne la valeur de isEnabled.
    }
}
