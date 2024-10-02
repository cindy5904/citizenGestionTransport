package org.example.server.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.server.dto.TransportLineDtoGet;
import org.example.server.dto.TransportLineDtoPost;
import org.example.server.entity.Notification;
import org.example.server.entity.Schedule;
import org.example.server.entity.TransportLine;
import org.example.server.repository.NotificationRepository;
import org.example.server.repository.ScheduleRepository;
import org.example.server.repository.TransportLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransportLineService {

    @Autowired
    private TransportLineRepository transportLineRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<TransportLine> getAllTransportLines() {
        return transportLineRepository.findAll();
    }

    public TransportLine getTransportLineById(Long id) {
        return transportLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TransportLine not found"));
    }

    public TransportLine saveTransportLine(TransportLine transportLine) {
        return transportLineRepository.save(transportLine);
    }

    public TransportLine updateTransportLine(Long id, TransportLineDtoPost transportLineDetails) {
        Optional<TransportLine> existingTransportLineOpt = transportLineRepository.findById(id);

        if (existingTransportLineOpt.isPresent()) {
            TransportLine transportLine = existingTransportLineOpt.get();

            transportLine.setName(transportLineDetails.getName());
            transportLine.setOrigin(transportLineDetails.getOrigin());
            transportLine.setDestination(transportLineDetails.getDestination());

            if (transportLineDetails.getNotificationIds() != null) {
                List<Notification> notifications = new ArrayList<>();
                for (Long notificationId : transportLineDetails.getNotificationIds()) {
                    Notification notification = notificationRepository.findById(notificationId)
                            .orElseThrow(() -> new EntityNotFoundException("Notification with id " + notificationId + " not found"));
                    notifications.add(notification);
                }
                transportLine.setNotifications(notifications);
            }

            if (transportLineDetails.getScheduleIds() != null) {
                List<Schedule> schedules = new ArrayList<>();
                for (Long scheduleId : transportLineDetails.getScheduleIds()) {
                    Schedule schedule = scheduleRepository.findById(Math.toIntExact(scheduleId))
                            .orElseThrow(() -> new EntityNotFoundException("Schedule with id " + scheduleId + " not found"));
                    schedules.add(schedule);
                }
                transportLine.setSchedules(schedules);
            }

            return transportLineRepository.save(transportLine);
        } else {
            throw new EntityNotFoundException("TransportLine with id " + id + " not found");
        }
    }

    public TransportLineDtoGet createTransportLine(TransportLineDtoPost transportLineDtoPost) {

        TransportLine transportLine = new TransportLine();
        transportLine.setName(transportLineDtoPost.getName());
        transportLine.setOrigin(transportLineDtoPost.getOrigin());
        transportLine.setDestination(transportLineDtoPost.getDestination());
        TransportLine savedTransportLine = transportLineRepository.save(transportLine);

        TransportLineDtoGet transportLineDtoGet = new TransportLineDtoGet();
        transportLineDtoGet.setId(savedTransportLine.getId());
        transportLineDtoGet.setName(savedTransportLine.getName());
        transportLineDtoGet.setOrigin(savedTransportLine.getOrigin());
        transportLineDtoGet.setDestination(savedTransportLine.getDestination());

        transportLineDtoGet.setNotifications(Collections.emptyList());
        transportLineDtoGet.setSchedules(Collections.emptyList());
        return transportLineDtoGet;
    }
    public void deleteTransportLineById(Long id) {
        if (!transportLineRepository.existsById(id)) {
            throw new EntityNotFoundException("TransportLine with id " + id + " not found");
        }

        TransportLine transportLine = transportLineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TransportLine with id " + id + " not found"));

        if (transportLine.getNotifications() != null) {
            notificationRepository.deleteAll(transportLine.getNotifications());
        }

        if (transportLine.getSchedules() != null) {
            scheduleRepository.deleteAll(transportLine.getSchedules());
        }
        transportLineRepository.deleteById(id);
    }


}
