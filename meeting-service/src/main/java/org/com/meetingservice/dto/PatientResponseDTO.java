package org.com.meetingservice.dto;

import lombok.Data;

@Data
public class PatientResponseDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String weight;
    private String height;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String address;
}