package org.com.meetingservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


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
    private String meetingDate;

    @Size(max = 256)
    private String notes;
}