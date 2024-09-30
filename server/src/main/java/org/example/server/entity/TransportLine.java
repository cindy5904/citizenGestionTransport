package org.example.server.entity;

import javax.sound.sampled.Line;
import java.util.List;

public class TransportLine {
    private int id;
    private String name;
    private String origin;
    private String destination;
    private List<Shedule> Shedules;

    public TransportLine(List<Shedule> shedules) {
        Shedules = shedules;
    }
}
