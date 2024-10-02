package org.example.server.dto;

import org.example.server.enums.DaysOfWeeks;

public class ScheduleDtoGet {
    private Long id;
    private DaysOfWeeks dayOfWeek;
    private String time;
    private Long transportLineId;
}
