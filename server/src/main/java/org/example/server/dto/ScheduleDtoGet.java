package org.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.server.enums.DaysOfWeeks;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDtoGet {
    private Long id;
    private DaysOfWeeks dayOfWeek;
    private String time;
    private Long transportLineId;
}
