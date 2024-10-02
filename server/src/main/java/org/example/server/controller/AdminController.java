package org.example.server.controller;

import org.example.server.entity.Admin;
import org.example.server.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Récupérer tous les admins
    @GetMapping
    public Iterable<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Récupérer un admin par son ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminRepository.findById(id);
    }

    // Créer un nouvel admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // Mettre à jour un admin
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        return adminRepository.save(updatedAdmin);
    }

    // Supprimer un admin
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }

}
