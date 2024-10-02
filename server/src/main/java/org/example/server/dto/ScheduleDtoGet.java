package org.example.server.dto.schedule;

import org.example.server.enums.DaysOfWeeks;

public class ScheduleDtoGet {
    private Long id;
    private DaysOfWeeks dayOfWeek;
    private String time;
    private Long transportLineId;
}
