package org.com.appointmentservvice.dto;

import lombok.Data;

@Data
public class DoctorResponseDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String specialization;
    private String rating;
    private String doctorStatus;
}