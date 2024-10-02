package org.example.server.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.entity.TransportLine;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportLineDtoGet {
    private int id;
    private String name;
    private String origin;
    private String destination;

}
