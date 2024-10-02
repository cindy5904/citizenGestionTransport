package org.example.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Inscription pour Citizen
    @PostMapping("/citizen/register")
    public ResponseEntity<String> registerCitizen(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto, "CITIZEN");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Inscription pour Admin
    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto, "ADMIN");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Connexion pour Citizen et Admin
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
}
