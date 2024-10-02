package org.example.server.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDtoGet {
    private int id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime expireddAt;
    private boolean isActive;
}
