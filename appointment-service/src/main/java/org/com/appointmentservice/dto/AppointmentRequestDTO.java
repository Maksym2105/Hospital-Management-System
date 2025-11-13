package org.com.appointmentservice.dto;

import lombok.Data;

@Data
public class AppointmentRequestDTO {
    private String doctorId;
    private String patientId;
    private String reason;
    private String date;
}