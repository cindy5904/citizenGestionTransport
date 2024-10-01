package org.example.server.dto;

import java.time.LocalDateTime;

public class NotificationDtoPost {
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime expireddAt;
    private boolean isActive;
}
