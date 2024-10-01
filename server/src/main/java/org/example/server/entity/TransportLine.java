package org.example.server.entity;

import jakarta.persistence.*;

import javax.sound.sampled.Line;
import java.util.List;
@Entity
@Table(name= "transport_lines")

public class TransportLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String origin;

    private String destination;

    @OneToMany(mappedBy = "transportLine", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "transportLine", cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    // Relation avec TransportType (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "transport_type_id", nullable = false)
    private TransportType transportType;

    // Constructeurs, Getters et Setters
    public TransportLine() {}

    public TransportLine(String name, String origin, String destination) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }
}
