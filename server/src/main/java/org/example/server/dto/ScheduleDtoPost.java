package org.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDtoPost {
    private String dayOfWeek;
    private String time;
    private Long transportLineId;

}
