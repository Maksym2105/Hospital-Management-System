package org.com.meetingservice.dto;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class ScheduleResponseDTO {

    private String scheduleStartTime;
    private String scheduleEndTime;
    private String scheduleDate;
    private String breakStartTime;
    private String breakEndTime;
    private DayOfWeek dayOfWeek;
    private String isDayOff;
}