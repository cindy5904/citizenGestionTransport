package org.example.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transport_types")
public class TransportType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;  // Type de transport, par exemple "Bus", "Train", etc.

    // Relation avec TransportLine
    @OneToMany(mappedBy = "transport_type", cascade = CascadeType.ALL)
    private List<TransportLine> transportLines;


}
