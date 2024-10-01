package org.example.server.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import org.example.server.entity.Notification;
import org.example.server.entity.TransportLine;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository  extends JpaRepository<Notification, Long>{

    // Rechercher toutes les notifications associées à une ligne de transport spécifique
    List<Notification> findByTransportLine(TransportLine transportLine);

    // Rechercher toutes les notifications actives pour une ligne de transport donnée
    List<Notification> findByTransportLineAndIsActiveTrue(TransportLine transportLine);

    // Rechercher toutes les notifications inactives pour une ligne de transport donnée
    List<Notification> findByTransportLineAndIsActiveFalse(TransportLine transportLine);

    // Rechercher toutes les notifications actives ayant expiré pour une ligne de transport donnée
    List<Notification> findByTransportLineAndIsActiveTrueAndExpiredAtBefore(TransportLine transportLine, LocalDate date);

    // Rechercher toutes les notifications actives pour toutes les lignes de transport
    List<Notification> findByIsActiveTrue();

    // Rechercher toutes les notifications inactives pour toutes les lignes de transport
    List<Notification> findByIsActiveFalse();;
}
