package org.example.server.dto.schedule;

import java.time.LocalDateTime;

public class NotificationDtoGet {
    private int id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime expireddAt;
    private boolean isActive;
}
