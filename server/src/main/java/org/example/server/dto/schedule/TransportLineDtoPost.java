package org.example.server.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.entity.Notification;
import org.example.server.entity.Schedule;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportLineDtoPost {
    private String name;
    private String origin;
    private String destination;

    public List<Notification> getNotifications() {
    }

    public List<Schedule> getSchedules() {
    }
}
