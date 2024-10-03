package org.example.server.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notifications")
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime expiredAt;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "transport_line_id")
    private TransportLine transportLine;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "citizen_notification",
            joinColumns = @JoinColumn(name = "notification_id",  referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "citizen_id",  referencedColumnName = "id"))
    private List<Citizen> citizens;


    public Notification() {
    }

    public Notification(String description, LocalDateTime createdAt, LocalDateTime expiredAt, boolean isActive, TransportLine transportLine) {
        this.description = description;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.isActive = isActive;
        this.transportLine = transportLine;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public boolean IsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public TransportLine getTransportLine() {
        return transportLine;
    }

    public void setTransportLine(TransportLine transportLine) {
        this.transportLine = transportLine;
    }
    
    public boolean isIsActive() {
        return isActive;
    }
}



