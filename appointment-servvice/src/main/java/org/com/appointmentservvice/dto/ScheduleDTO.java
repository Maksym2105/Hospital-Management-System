package org.com.appointmentservvice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ScheduleDTO {

    private UUID id;
    private UUID doctorId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isAvailable;
}