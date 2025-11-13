package org.com.doctorservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.doctorservice.additional.CustomDayOfTheWeek;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleRequestDTO {

    @NotNull(message = "Required start time")
    private LocalTime scheduleStartTime;

    @NotNull(message = "Required end time")
    private LocalTime scheduleEndTime;

    @NotNull(message = "Required date")
    private LocalDate scheduleDate;

    @NotNull(message = "Required start break time")
    private LocalTime breakStartTime;

    @NotNull(message = "Required end break time")
    private LocalTime breakEndTime;

    @NotNull(message = "Required day of the week")
    private CustomDayOfTheWeek customDayOfTheWeek;

    @NotNull(message = "Required day off")
    private Boolean isDayOff;
}