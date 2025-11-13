package org.com.doctorservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.doctorservice.additional.CustomDayOfTheWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID scheduleId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    private LocalDate scheduleDate;

    @NotNull
    private LocalTime breakStartTime;

    @NotNull
    private LocalTime breakEndTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private CustomDayOfTheWeek customDayOfTheWeek;

    @NotNull
    private boolean isDayOff;
}