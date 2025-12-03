package org.com.doctorservice.mapper;

import lombok.experimental.UtilityClass;
import org.com.doctorservice.dto.DoctorRequestDTO;
import org.com.doctorservice.dto.DoctorResponseDTO;
import org.com.doctorservice.dto.ScheduleRequestDTO;
import org.com.doctorservice.dto.ScheduleResponseDTO;
import org.com.doctorservice.exception.EmptyScheduleException;
import org.com.doctorservice.messages.DoctorServiceMessages;
import org.com.doctorservice.model.Doctor;
import org.com.doctorservice.model.Schedule;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DoctorMapper {
    public static DoctorResponseDTO toResponseDTO(Doctor doctor) {
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

        return doctorResponseDTO;
    }

    public static Doctor toModel(DoctorRequestDTO doctorRequestDTO) {
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

        return doctor;
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
                        .isDayOff(String.valueOf(schedule.isDayOff()))
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