package org.example.server.controller;

import org.example.server.dto.schedule.NotificationDtoGet;
import org.example.server.dto.schedule.NotificationDtoPost;
import org.example.server.entity.Notification;
import org.example.server.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")

public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notification>> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }
    @PostMapping
    public ResponseEntity<NotificationDtoGet> createNotification(@RequestBody NotificationDtoPost notificationDtoPost) {
        NotificationDtoGet createdNotification = notificationService.createNotification(notificationDtoPost);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDtoGet> updateNotification(
            @PathVariable Long id,
            @RequestBody NotificationDtoPost notificationDtoPost) {
        NotificationDtoGet updatedNotification = notificationService.updateNotification(id, notificationDtoPost);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }


}



