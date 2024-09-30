package org.example.server.service;

import org.example.server.entity.Notification;
import org.example.server.entity.TransportLine;

import java.util.Date;
import java.util.List;

public interface NotificationService {

    //crée une notification
    Notification saveNotification(Notification notification);

    // Mettre à jour les notifications
    Notification updateNotification(Notification notification);

    //supprimer les notifications
    void deleteNotification(Notification notification);

    // retourner toutes les notifications
    List<Notification> getNotifications();

    // Retourne les notifications actives
    List<Notification> getActiveNotifications();

    // Retourne les notifications expirées
    List<Notification> getExpiredNotifications(Date currentDate);

    // Retourne les notifications par ligne de transport
    List<Notification> getNotificationsByTransportLine(TransportLine transportLine);

    // Retourne les notifications actives pour une ligne de transport spécifique
    List<Notification> getActiveNotificationsByTransportLine(TransportLine transportLine);

}
