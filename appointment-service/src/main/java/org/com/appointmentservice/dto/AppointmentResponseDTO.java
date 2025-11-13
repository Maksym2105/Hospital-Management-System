package org.com.appointmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.appointmentservice.additional.AppointmentStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponseDTO {
    private String appointmentId;

    private String patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;
    private String patientPhoneNumber;

    private String doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorEmail;
    private String doctorPhoneNumber;

    private String reason;
    private String appointmentDate;
    private AppointmentStatus appointmentStatus;
}