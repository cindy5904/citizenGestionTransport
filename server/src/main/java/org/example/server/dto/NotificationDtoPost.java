package org.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDtoPost {
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime expireddAt;
    private boolean isActive;
}
