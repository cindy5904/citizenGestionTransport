package org.example.server.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "notifications")

public class Notification  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredAt;
    @Column(nullable = false)
    private boolean isActive;


    @ManyToOne
    @JoinColumn(name= "transport_line_id", nullable = false)
    private transportLine TransportLine;

    public Notification() {}

    public Notification(long id, String description, Date createdAt, Date expiredAt, boolean isActive, transportLine transportLine) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.isActive = isActive;
        TransportLine = transportLine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public transportLine getTransportLine() {
        return TransportLine;
    }

    public void setTransportLine(transportLine transportLine) {
        TransportLine = transportLine;
    }
}
