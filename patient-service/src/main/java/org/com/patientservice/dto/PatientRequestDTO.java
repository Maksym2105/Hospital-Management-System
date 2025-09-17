package org.com.patientservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.patientservice.dto.validators.CreatePatientValidationGroup;
import org.com.patientservice.model.genders.Gender;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {

    @NotBlank(message = "{firstName.blank}")
    @Size(max = 50, message = "{firstName.size}")
    private String firstName;

    @NotBlank(message = "{lastName.blank}")
    @Size(max = 50, message = "{lastName.size}")
    private String lastName;

    @NotNull(groups = CreatePatientValidationGroup.class, message = "{gender.blank}")
    private Gender gender;

    @NotNull(message = "{weight.blank}")
    @DecimalMin(value = "0.1", message = "{weight.min}")
    @DecimalMax(value = "300.0", message = "{weight.max}")
    private Double weight;

    @NotNull(groups = CreatePatientValidationGroup.class, message = "{height.blank}")
    @DecimalMin(value = "0.1", message = "{height.min}")
    @DecimalMax(value = "250.0", message = "{height.max}")
    private Double height;

    @NotBlank(message = "{email.blank}")
    @Email(message = "{email.constraint}")
    @Size(max = 100, message = "{email.size}")
    private String email;

    @NotBlank(message = "{phoneNumber.blank}")
    @Size(min = 1, max = 100, message = "{phoneNumber.size}")
    private String phoneNumber;

    @NotNull(message = "{dateOfBirth.blank}")
    @Past(message = "{dateOfBirth.past}")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotBlank(message = "{address.blank}")
    private String address;

    @NotNull(groups = CreatePatientValidationGroup.class, message = "{registeredDate.blank}")
    @PastOrPresent(message = "{registeredDate.pastOrPresent}")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registeredDate;
}