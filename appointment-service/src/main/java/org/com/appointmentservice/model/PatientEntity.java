package org.com.appointmentservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientEntity {

    @Id
    private UUID id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String gender;

    @NotNull
    private String weight;

    @NotNull
    private String height;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String dateOfBirth;

    @NotNull
    private String address;

    @Column(nullable = false)
    private String registeredDate;
}