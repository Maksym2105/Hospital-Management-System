package org.com.appointmentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.appointmentservice.additional.AppointmentStatus;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID appointmentId;

    @NotNull
    private UUID patientId;

    @NotNull
    private UUID doctorId;

    @NotNull
    private String reason;

    @NotNull
    private String date;
}