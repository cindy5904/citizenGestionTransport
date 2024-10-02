package org.example.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sound.sampled.Line;
import java.util.List;

@Table(name= "transport_lines")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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


}
