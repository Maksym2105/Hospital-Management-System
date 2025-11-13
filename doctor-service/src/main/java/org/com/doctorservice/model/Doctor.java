package org.com.doctorservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.com.doctorservice.additional.DoctorStatus;
import org.com.doctorservice.additional.Genders;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID doctorId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Genders gender;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String specialization;

    @Column(precision = 2, scale = 1)
    @NotNull
    private BigDecimal rating;

    @Enumerated(EnumType.STRING)
    @NotNull
    private DoctorStatus doctorStatus;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;
}