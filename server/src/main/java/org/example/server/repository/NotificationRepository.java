package org.example.server.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import org.example.server.entity.Notification;
import org.example.server.entity.TransportLine;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository  extends JpaRepository<Notification, Long>{

    // Méthode pour trouver les notifications actives
    List<Notification> findByIsActive(Boolean isActive);

    //Méthode pour trouver les notifications expirées
    List<Notification> findByExpiredBefore(Date currentDate);

    //Méthode pour trouver les notifications par transportLine
    List<Notification> findByTransportLine(TransportLine transportLine);

    // Méthode pour trouver les notifications actives par ligne de transport
    List<Notification> findByTransportLineAndIsActive(TransportLine transportLine, Boolean isActive);

}
