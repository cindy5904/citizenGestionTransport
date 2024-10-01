package org.example.server.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.server.entity.Notification;
import org.example.server.entity.TransportLine;
import org.example.server.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private TransportLineService transportLineService;

    // Récupérer toutes les notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Récupérer une notification par ID
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }
    // Récupérer les notifications actives pour une ligne de transport donnée
    public List<Notification> getActiveNotificationsByTransportLine(Long transportLineId) {
        Optional<TransportLine> transportLine = Optional.ofNullable(transportLineService.getTransportLineById(transportLineId));
        if (transportLine.isPresent()) {
            return notificationRepository.findByTransportLineAndIsActiveTrue(transportLine.get());
        } else {
            throw new RuntimeException("TransportLine with id " + transportLineId + " not found");
        }
    }

    // Créer une nouvelle notification
    public Notification createNotification(Notification notification, Long transportLineId) {
        // Vérifier si la ligne de transport existe
        Optional<TransportLine> transportLine = Optional.ofNullable(transportLineService.getTransportLineById(transportLineId));
        if (transportLine.isPresent()) {
            notification.setTransportLine(transportLine.get());
            return notificationRepository.save(notification);
        } else {
            throw new RuntimeException("TransportLine with id " + transportLineId + " not found");
        }
    }

    // Mettre à jour une notification existante
    public Notification updateNotification(Long id, Notification notificationDetails) {
        Optional<Notification> existingNotification = notificationRepository.findById(id);
        if (existingNotification.isPresent()) {
            Notification notification = existingNotification.get();
            notification.setDescription(notificationDetails.getDescription());
            notification.setCreatedAt(notificationDetails.getCreatedAt());
            notification.setExpiredAt(notificationDetails.getExpiredAt());
            notification.setActive(notificationDetails.getIsActive());
            notification.setTransportLine(notificationDetails.getTransportLine());
            return notificationRepository.save(notification);
        } else {
            throw new RuntimeException("Notification with id " + id + " not found");
        }
    }

    // Supprimer une notification par ID
    public void deleteNotification(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Notification with id " + id + " not found");
        }
    }

    // Désactiver les notifications expirées pour une ligne de transport donnée
    public void deactivateExpiredNotifications(Long transportLineId) {
        Optional<TransportLine> transportLine = Optional.ofNullable(transportLineService.getTransportLineById(transportLineId));
        if (transportLine.isPresent()) {
            List<Notification> notifications = notificationRepository.findByTransportLineAndIsActiveTrue(transportLine.get());
            notifications.forEach(notification -> {
                if (notification.getExpiredAt().isBefore(LocalDate.now().atStartOfDay())) {
                    notification.setActive(false);
                    notificationRepository.save(notification);
                }
            });
        } else {
            throw new RuntimeException("TransportLine with id " + transportLineId + " not found");
        }
    }
}
