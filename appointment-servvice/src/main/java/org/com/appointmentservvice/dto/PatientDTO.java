package org.com.appointmentservvice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PatientDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}