package org.com.appointmentservvice.dto;

import lombok.Data;
import org.com.appointmentservvice.additional.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentResponse {

    private UUID id;
    private DoctorDTO doctorDTO;
    private PatientDTO patientDTO;
    private LocalDateTime appointmentDate;
    private AppointmentStatus appointmentStatus;
    private String status;

}