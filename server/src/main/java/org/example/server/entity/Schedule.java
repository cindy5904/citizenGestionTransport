package org.example.server.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.enums.DaysOfWeeks;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate scheduleHour;
    @Enumerated(EnumType.STRING)
    private DaysOfWeeks dayOfWeek;
    private LocalTime time;
    @ManyToOne
    private TransportLine line;
}
