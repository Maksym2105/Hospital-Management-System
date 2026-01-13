package org.com.meetingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleResponseDTO {

    private String scheduleStartTime;
    private String scheduleEndTime;
    private String scheduleDate;
    private String breakStartTime;
    private String breakEndTime;
    private String dayOfWeek;
    private String isDayOff;
}