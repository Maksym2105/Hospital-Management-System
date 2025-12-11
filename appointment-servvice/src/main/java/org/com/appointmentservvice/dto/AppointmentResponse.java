package org.com.appointmentservvice.dto;

import lombok.Data;

@Data
public class AppointmentResponse {

    private String id;

    private String doctorFirstName;
    private String doctorLastName;
    private String doctorEmail;
    private String doctorPhone;
    private String doctorSpecialization;

    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;
    private String patientPhone;

    private String appointmentDate;
    private String startTime;
    private String endTime;
    private String appointmentStatus;
    private String notes;

    private String createdAt;
    private String updatedAt;

}