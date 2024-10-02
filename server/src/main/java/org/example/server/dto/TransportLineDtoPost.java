package org.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.entity.Notification;
import org.example.server.entity.Schedule;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportLineDtoPost {
    private String name;
    private String origin;
    private String destination;
    private List<Long> notificationIds;
    private List<Long> scheduleIds;

}
