package org.example.server.entity;

import jakarta.persistence.Entity;

import java.util.Date;
@Entity
public class Notification  {
    private int id;
    private String description;
    private Date createdAt;
    private Date expiredAt;
    private boolean isActive;
    private transportLine TransportLine;

    public Notification() {}

    public Notification(int id, String description, Date createdAt, Date expiredAt, boolean isActive, transportLine transportLine) {

        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.isActive = isActive;
        TransportLine = transportLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
