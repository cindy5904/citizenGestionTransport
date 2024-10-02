package org.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.entity.Notification;
import org.example.server.entity.Schedule;
import org.example.server.entity.TransportLine;

import java.util.List;
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
public class TransportLineDtoGet {
    private int id;
    private String name;
    private String origin;
    private String destination;
     private List<Notification> notifications;
     private List<Schedule> schedules;

}
