package org.com.meetingservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingRequest {

    @NotBlank
    @Size(min =1, max = 36)
    private String patientId;

    @NotBlank
    @Size(min =1, max = 36)
    private String doctorId;

    @NotBlank
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate meetingDate;

    @NotBlank
    @FutureOrPresent
    @JsonFormat(pattern = "HH-mm-ss")
    private LocalTime meetingStartTime;

    @NotBlank
    @FutureOrPresent
    @JsonFormat(pattern = "HH-mm-ss")
    private LocalTime meetingEndTime;

    @Size(max = 256)
    private String notes;
}