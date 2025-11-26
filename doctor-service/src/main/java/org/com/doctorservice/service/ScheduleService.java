package org.com.doctorservice.service;

import lombok.RequiredArgsConstructor;
import org.com.doctorservice.additional.CustomDayOfTheWeek;
import org.com.doctorservice.dto.ScheduleResponseDTO;
import org.com.doctorservice.exception.EmptyScheduleException;
import org.com.doctorservice.mapper.ScheduleMapper;
import org.com.doctorservice.messages.DoctorServiceMessages;
import org.com.doctorservice.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleResponseDTO> findAllByDoctorId(UUID doctorId) {
        return ScheduleMapper.mapListOfSchedulesToResponseDTO(scheduleRepository.findByDoctorDoctorId(doctorId));
    }

    public List<ScheduleResponseDTO> findAllByDoctorIdAndCustomDayOfTheWeek(UUID doctorId, CustomDayOfTheWeek customDayOfTheWeek) {
        return ScheduleMapper.mapListOfSchedulesToResponseDTO(scheduleRepository.findByDoctorDoctorIdAndCustomDayOfTheWeek(doctorId, customDayOfTheWeek));
    }

    public List<ScheduleResponseDTO> findAllByDoctorIdAndScheduleDateBetween(UUID doctorId, LocalDate start, LocalDate end) {
        return ScheduleMapper.mapListOfSchedulesToResponseDTO(scheduleRepository.findByDoctorDoctorIdAndScheduleDateBetween(doctorId, start, end));
    }

    public List<ScheduleResponseDTO> findAllByDoctorIdAndStartTimeBetweenAndEndTimeBetween(UUID doctorId, LocalTime start, LocalTime end) {
        return ScheduleMapper.mapListOfSchedulesToResponseDTO(scheduleRepository.findByDoctorDoctorIdAndStartTimeBeforeAndEndTimeAfter(doctorId, start, end));
    }

    public ScheduleResponseDTO findByDoctorIdAndScheduleDate(UUID doctorId, LocalDate scheduleDate) {
        return ScheduleMapper.mapScheduleToResponseDTO(scheduleRepository.findByDoctorDoctorIdAndScheduleDate(doctorId, scheduleDate).orElseThrow(
                () -> new EmptyScheduleException(DoctorServiceMessages.EMPTY_SCHEDULE.getMessage())));
    }
}