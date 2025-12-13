package org.com.meetingservice.dto;

import lombok.Data;

@Data
public class MeetingResponse {

    private String id;

    private String doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorPhoneNumber;
    private String specialization;

    private String patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientPhoneNumber;

    private String meetingDate;
    private String startTime;
    private String endTime;
    private String meetingStatus;
    private String notes;

    private String createdAt;
    private String updatedAt;
}