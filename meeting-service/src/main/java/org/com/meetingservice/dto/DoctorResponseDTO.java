package org.com.meetingservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

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
    @JsonProperty("scheduleList")
    private List<ScheduleResponseDTO> schedulesList;
}