package org.com.meetingservice.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.meetingservice.additional.MeetingStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Document(collection = "meeting")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meeting {

    @Id
    private UUID id;

    @Field(name = "doctor_id")
    @NotNull
    private UUID doctorId;

    @Field(name = "schedule_id")
    @NotNull
    private UUID scheduleId;

    @Field(name = "patient_id")
    @NotNull
    private UUID patientId;

    @Field(name = "date")
    @NotNull
    private LocalDate meetingDate;

    @Field(name = "start_time")
    @NotNull
    private LocalTime meetingStartTime;

    @Field(name = "end_time")
    @NotNull
    private LocalTime meetingEndTime;

    @Field(name = "status")
    @NotNull
    private MeetingStatus meetingStatus;

    @Field(name = "notes")
    private String notes;

    @CreatedDate
    @Field(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field(name = "updated_at")
    private LocalDateTime updatedAt;
}