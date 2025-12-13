package org.com.meetingservice.dto;

import lombok.Data;

@Data
public class ScheduleResponseDTO {

    private String scheduleStartTime;
    private String scheduleEndTime;
    private String scheduleDate;
    private String breakStartTime;
    private String breakEndTime;
    private String dayOfWeek;
    private String isDayOff;
}