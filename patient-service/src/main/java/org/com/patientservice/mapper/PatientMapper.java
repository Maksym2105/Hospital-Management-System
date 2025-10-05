package org.com.patientservice.mapper;

import lombok.extern.slf4j.Slf4j;
import org.com.patientservice.dto.PatientRequestDTO;
import org.com.patientservice.dto.PatientResponseDTO;
import org.com.patientservice.exception.EmptyComponentException;
import org.com.patientservice.exception.EmptyEntityException;
import org.com.patientservice.messages.PatientMessages;
import org.com.patientservice.model.Patient;

import java.util.Map;

@Slf4j
public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {

        if (patient == null) {
            throw new EmptyEntityException(PatientMessages.MODEL_EMPTY.getMessage());
        }

        PatientResponseDTO patientResponseDTO = PatientResponseDTO.builder()
                .id(patient.getPatientId().toString())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .gender(patient.getGender().toString())
                .weight(patient.getWeight().toString())
                .height(patient.getHeight().toString())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .dateOfBirth(patient.getDateOfBirth().toString())
                .address(patient.getAddress())
                .build();

        validate(patientResponseDTO);

        return patientResponseDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        if (patientRequestDTO == null) {
            throw new EmptyComponentException(PatientMessages.REQUEST_EMPTY.getMessage());
        }

        Patient patient = Patient.builder()
                .firstName(patientRequestDTO.getFirstName())
                .lastName(patientRequestDTO.getLastName())
                .gender(patientRequestDTO.getGender())
                .weight(patientRequestDTO.getWeight())
                .height(patientRequestDTO.getHeight())
                .email(patientRequestDTO.getEmail())
                .phoneNumber(patientRequestDTO.getPhoneNumber())
                .dateOfBirth(patientRequestDTO.getDateOfBirth())
                .address(patientRequestDTO.getAddress())
                .registeredDate(patientRequestDTO.getRegisteredDate())
                .build();

        validate(patient);

        return patient;
    }

    private static void validate(PatientResponseDTO patientResponseDTO) {
        Map<String, String> responseMap = Map.of(
                "PatientId", patientResponseDTO.getId(),
                "FirstName", patientResponseDTO.getFirstName(),
                "LastName", patientResponseDTO.getLastName(),
                "Weight", patientResponseDTO.getWeight(),
                "Height", patientResponseDTO.getHeight(),
                "Email", patientResponseDTO.getEmail(),
                "PhoneNumber", patientResponseDTO.getPhoneNumber(),
                "DateOfBirth", patientResponseDTO.getDateOfBirth(),
                "Address", patientResponseDTO.getAddress()
        );

        responseMap.forEach((key, value) -> {
            if (value == null || value.isBlank()) {
                throw new EmptyComponentException(PatientMessages.RESPONSE_EMPTY.getMessage());
            }
        });

    }

    private static void validate(Patient patient) {
        Map<String, String> response = Map.of(
                "FirstName", patient.getFirstName(),
                "LastName", patient.getLastName(),
                "Weight", patient.getWeight().toString(),
                "Height", patient.getHeight().toString(),
                "Email", patient.getEmail(),
                "PhoneNumber", patient.getPhoneNumber(),
                "DateOfBirth", patient.getDateOfBirth().toString(),
                "Address", patient.getAddress(),
                "RegisteredDate", patient.getRegisteredDate().toString());


        response.forEach((key, value) -> {
            if (value == null || value.isBlank()) {
                throw new EmptyEntityException(PatientMessages.MODEL_EMPTY.getMessage());
            }
        });

    }
}