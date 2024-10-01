package org.example.server.service;

import org.example.server.entity.Notification;
import org.example.server.entity.TransportLine;
import org.example.server.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification saveNotification(Notification notification) {
        notification.setCreatedAt(new Date());
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        //verifier si la notification existe avant
        Optional<Notification> existNotification= notificationRepository.findById(id);
        if (existNotification.isPresent()) {
            Notification notification1 = existNotification.get();
            notification1.setDescription(updateNotification.getDescription());
            notification1.setExpiredAt(updateNotification.getExpiredAt());
            notification1.setActive(updateNotification.isActive());
            notification1.setTransportLine(updateNotification.getTrasportLine());
            return notificationRepository.save(notification1);
        }
        throw new RuntimeException("Notification not found with id: " + id);
    }

    @Override
    public void deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
    }

    @Override
    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getActiveNotifications() {
        return notificationRepository.findByIsActive(true);
    }

    @Override
    public List<Notification> getExpiredNotifications(Date currentDate) {
        return notificationRepository.findByExpiredBefore(currentDate);

    }

    @Override
    public List<Notification> getNotificationsByTransportLine(TransportLine transportLine) {
        return notificationRepository.findByTransportLine(transportLine);
    }

    @Override
    public List<Notification> getActiveNotificationsByTransportLine(TransportLine transportLine) {
        return notificationRepository.findByTransportLineAndIsActive(transportLine, true);
    }
}
