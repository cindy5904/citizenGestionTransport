package org.example.server.entity;

import jakarta.persistence.*;

import java.util.List;

public class TransportType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Type de transport, par exemple "Bus", "Train", etc.

    // Relation avec TransportLine
    @OneToMany(mappedBy = "transportType", cascade = CascadeType.ALL)
    private List<TransportLine> transportLines;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TransportLine> getTransportLines() {
        return transportLines;
    }

    public void setTransportLines(List<TransportLine> transportLines) {
        this.transportLines = transportLines;
    }
}
