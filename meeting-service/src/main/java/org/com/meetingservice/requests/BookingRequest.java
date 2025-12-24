package org.com.meetingservice.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class BookingRequest {

    @NotBlank(message = "Patient id required")
    @Size(min =1, max = 36, message = "Patient id must be under 36 digits")
    private String patientId;

    @NotBlank(message = "Doctor id required")
    @Size(min =1, max = 36, message = "Doctor id must be under 36 digits")
    private String doctorId;

    @NotBlank(message = "Date is required")
    @FutureOrPresent(message = "Date cannot be in past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Instant meetingDate;

    @NotBlank(message = "Start time is required")
    @FutureOrPresent(message = "Start time cannot be in past")
    @JsonFormat(pattern = "HH-mm-ss")
    private Instant meetingStartTime;

    @NotBlank(message = "End time is required")
    @FutureOrPresent(message = "End time cannot be in past")
    @JsonFormat(pattern = "HH-mm-ss")
    private Instant meetingEndTime;

    @Size(max = 256, message = "Notes must be under 256 digits")
    private String notes;
}