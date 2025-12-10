package org.com.appointmentservvice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookingRequest {

    private UUID doctorId;
    private UUID patientId;
    private String notes;
}