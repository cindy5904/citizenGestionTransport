package org.example.server.repository;

import org.example.server.entity.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransportTypeRepository extends JpaRepository<TransportType, Long> {
    // Rechercher un TransportType par son nom
    Optional<TransportType> findByType(String type);

    // Rechercher tous les TransportType contenant un mot-clé (case insensitive)
    List<TransportType> findByTypeContainingIgnoreCase(String keyword);

    // Supprimer un TransportType par son nom
    void deleteByType(String type);

}
