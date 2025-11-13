package org.com.doctorservice.mapper;

import lombok.experimental.UtilityClass;
import org.com.doctorservice.dto.DoctorRequestDTO;
import org.com.doctorservice.dto.DoctorResponseDTO;
import org.com.doctorservice.dto.ScheduleRequestDTO;
import org.com.doctorservice.dto.ScheduleResponseDTO;
import org.com.doctorservice.exception.EmptyComponentException;
import org.com.doctorservice.exception.EmptyModelException;
import org.com.doctorservice.exception.EmptyScheduleException;
import org.com.doctorservice.exception.NotValidException;
import org.com.doctorservice.messages.DoctorServiceMessages;
import org.com.doctorservice.model.Doctor;
import org.com.doctorservice.model.Schedule;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class DoctorMapper {
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static DoctorResponseDTO toResponseDTO(Doctor doctor) {
        if (doctor == null) {
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
                .doctorStatus(doctor.getDoctorStatus().toString())
                .scheduleList(toScheduleDTO(doctor.getSchedules()))
                .build();

        validate(doctorResponseDTO);

        return doctorResponseDTO;
    }

    public static Doctor toModel(DoctorRequestDTO doctorRequestDTO) {
        if (doctorRequestDTO == null) {
            throw new EmptyComponentException(DoctorServiceMessages.COMPONENT_IS_EMPTY.getMessage());
        }
        List<Schedule> listOfSchedules = toModelSchedule(doctorRequestDTO.getSchedule());

        Doctor doctor = Doctor.builder()
                .firstName(doctorRequestDTO.getFirstName())
                .lastName(doctorRequestDTO.getLastName())
                .gender(doctorRequestDTO.getGender())
                .email(doctorRequestDTO.getEmail())
                .phoneNumber(doctorRequestDTO.getPhoneNumber())
                .specialization(doctorRequestDTO.getSpecialization())
                .rating(doctorRequestDTO.getRating())
                .doctorStatus(doctorRequestDTO.getDoctorStatus())
                .schedules(listOfSchedules)
                .build();

        listOfSchedules.forEach(listOfSchedule -> listOfSchedule.setDoctor(doctor));

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
                "Rating", doctorResponseDTO.getRating()
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
                "Rating", doctor.getRating().toString()
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

    public static List<ScheduleResponseDTO> toScheduleDTO(List<Schedule> schedules) {
        if (schedules == null) {
            throw new EmptyScheduleException(DoctorServiceMessages.EMPTY_SCHEDULE.getMessage());
        }
        return schedules.stream()
                .map(schedule -> ScheduleResponseDTO.builder()
                        .dayOfWeek(schedule.getCustomDayOfTheWeek().toString().toUpperCase())
                        .scheduleStartTime(schedule.getStartTime().toString())
                        .scheduleEndTime(schedule.getEndTime().toString())
                        .scheduleDate(schedule.getScheduleDate().toString())
                        .breakStartTime(schedule.getBreakStartTime().toString())
                        .breakEndTime(schedule.getBreakEndTime().toString())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Schedule> toModelSchedule(List<ScheduleRequestDTO> scheduleRequestDTOs) {
        if (scheduleRequestDTOs == null || scheduleRequestDTOs.isEmpty()) {
            throw new EmptyScheduleException(DoctorServiceMessages.EMPTY_SCHEDULE.getMessage());
        }
        return scheduleRequestDTOs.stream()
                .map(scheduleRequestDTO -> Schedule.builder()
                        .startTime(scheduleRequestDTO.getScheduleStartTime())
                        .endTime(scheduleRequestDTO.getScheduleEndTime())
                        .scheduleDate(scheduleRequestDTO.getScheduleDate())
                        .breakStartTime(scheduleRequestDTO.getBreakStartTime())
                        .breakEndTime(scheduleRequestDTO.getBreakEndTime())
                        .customDayOfTheWeek(scheduleRequestDTO.getCustomDayOfTheWeek())
                        .isDayOff(scheduleRequestDTO.getIsDayOff())
                        .build())
                .collect(Collectors.toList());
    }
}