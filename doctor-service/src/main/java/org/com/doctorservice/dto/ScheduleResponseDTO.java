package org.com.doctorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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