package org.com.doctorservice.mapper;

import org.com.doctorservice.dto.DoctorRequestDTO;
import org.com.doctorservice.dto.DoctorResponseDTO;
import org.com.doctorservice.exception.EmptyComponentException;
import org.com.doctorservice.exception.EmptyModelException;
import org.com.doctorservice.exception.NotValidException;
import org.com.doctorservice.messages.DoctorServiceMessages;
import org.com.doctorservice.model.Doctor;

import java.util.Map;

public class DoctorMapper {

    public static DoctorResponseDTO toResponseDTO(Doctor doctor) {
        if(doctor == null) {
            throw new EmptyModelException(DoctorServiceMessages.DOCTOR_IS_EMPTY.getMessage());
        }
        DoctorResponseDTO doctorResponseDTO = DoctorResponseDTO.builder()
                .id(doctor.getDoctorId().toString())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .gender(doctor.getGender().toString())
                .email(doctor.getEmail())
                .phoneNumber(doctor.getPhoneNumber())
                .specialization(doctor.getSpecialization())
                .rating(doctor.getRating().toString())
                .schedule(doctor.getSchedule())
                .build();

        validate(doctorResponseDTO);

        return doctorResponseDTO;
    }

    public static Doctor toModel(DoctorRequestDTO doctorRequestDTO) {
        if(doctorRequestDTO == null) {
            throw new EmptyComponentException(DoctorServiceMessages.COMPONENT_IS_EMPTY.getMessage());
        }

        Doctor doctor = Doctor.builder()
                .firstName(doctorRequestDTO.getFirstName())
                .lastName(doctorRequestDTO.getLastName())
                .gender(doctorRequestDTO.getGender())
                .email(doctorRequestDTO.getEmail())
                .phoneNumber(doctorRequestDTO.getPhoneNumber())
                .specialization(doctorRequestDTO.getSpecialization())
                .rating(doctorRequestDTO.getRating())
                .schedule(doctorRequestDTO.getSchedule())
                .build();

        validate(doctor);

        return doctor;
    }

    private static void validate(DoctorResponseDTO doctorResponseDTO) {
        Map<String, String> map = Map.of(
                "id", doctorResponseDTO.getId(),
                "FirstName", doctorResponseDTO.getFirstName(),
                "LastName", doctorResponseDTO.getLastName(),
                "Gender", doctorResponseDTO.getGender(),
                "Email", doctorResponseDTO.getEmail(),
                "PhoneNumber", doctorResponseDTO.getPhoneNumber(),
                "Specialization", doctorResponseDTO.getSpecialization(),
                "Rating", doctorResponseDTO.getRating(),
                "Schedule", doctorResponseDTO.getSchedule()
        );

        validateFields(map, new NotValidException(DoctorServiceMessages.ARGUMENTS_NOT_VALID.getMessage()));
    }

    private static void validate(Doctor doctor) {
        Map<String, String> map = Map.of(
                "FirstName", doctor.getFirstName(),
                "LastName", doctor.getLastName(),
                "Gender", doctor.getGender().toString(),
                "Email", doctor.getEmail(),
                "PhoneNumber", doctor.getPhoneNumber(),
                "Specialization", doctor.getSpecialization(),
                "Rating", doctor.getRating().toString(),
                "Schedule", doctor.getSchedule()
        );

        validateFields(map, new NotValidException(DoctorServiceMessages.ARGUMENTS_NOT_VALID.getMessage()));
    }

    private static void validateFields(Map<String, ?> fields, NotValidException notValidException) {
        fields.forEach((key, value) -> {
            if (value == null || value.toString().isBlank()) {
                throw notValidException;
            }
        });
    }
}