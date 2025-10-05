package org.com.doctorservice.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.doctorservice.dto.validators.CreateDoctorValidationGroup;
import org.com.doctorservice.model.gender.Genders;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequestDTO {

    @NotBlank(message = "{not.blank.doctor.firstName}")
    @Size(max = 50, message = "{size.doctor.firstName}")
    private String firstName;

    @NotBlank(message = "{not.blank.doctor.lastName}")
    @Size(max = 50, message = "{size.max.doctor.lastName}")
    private String lastName;

    @NotNull(groups = CreateDoctorValidationGroup.class, message = "{not.null.doctor.gender}")
    private Genders gender;

    @NotBlank(message = "{not.blank.doctor.email}")
    @Email(message = "{unique.doctor.email}")
    private String email;

    @NotBlank(message = "{not.blank.doctor.phoneNumber}")
    private String phoneNumber;

    @NotBlank(message = "{not.blank.doctor.specialization}")
    private String specialization;

    @NotNull(groups = CreateDoctorValidationGroup.class, message = "{not.null.doctor.rating}")
    @DecimalMin(value = "0.0", message = "{decimal.min.doctor.rating}")
    @DecimalMax(value = "0.0", message = "{decimal.max.doctor.rating}")
    private BigDecimal rating;

    @NotBlank(message = "{not.blank.doctor.schedule}")
    private String schedule;
}