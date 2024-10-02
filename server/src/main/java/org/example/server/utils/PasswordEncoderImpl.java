package org.example.server.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Exemple d'encodage d'un mot de passe
        String rawPassword = "votreMotDePasse"; // Remplacez par le mot de passe à encoder
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Afficher le mot de passe encodé
        System.out.println("Mot de passe encodé : " + encodedPassword);
    }
}
