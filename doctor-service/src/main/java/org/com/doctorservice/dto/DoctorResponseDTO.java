package org.com.doctorservice.dto;

import lombok.Builder;
import lombok.Data;
import org.com.doctorservice.model.Schedule;

import java.util.List;

@Data
@Builder
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
    private List<ScheduleResponseDTO> scheduleList;
}