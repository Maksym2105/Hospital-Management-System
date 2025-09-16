package org.com.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.com.patientservice.model.genders.Gender;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private Double weight;

    @NotNull
    private Double height;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String address;

    @NotNull
    private LocalDate registeredDate;

}