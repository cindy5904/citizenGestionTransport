package org.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {

    private String accessToken; // Le JWT proprement dit
    private String tokenType = "Bearer"; // Le type de token (souvent "Bearer")
    private String email;  // L'email de l'utilisateur pour qui le token est valide
   // private List<String> roles;  // Les rôles ou permissions de l'utilisateur

}
