package org.example.server.dto.schedule;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import java.util.List;

public class ScheduleDtoPost {
    private String dayOfWeek;
    private String time;
    private Long transportLineId;

}
