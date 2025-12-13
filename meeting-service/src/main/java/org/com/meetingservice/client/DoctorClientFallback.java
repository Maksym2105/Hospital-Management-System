package org.com.meetingservice.client;

import lombok.extern.slf4j.Slf4j;
import org.com.meetingservice.additional.CustomDayOfTheWeek;
import org.com.meetingservice.additional.Genders;
import org.com.meetingservice.additional.Specialization;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.dto.ScheduleResponseDTO;
import org.com.meetingservice.exception.ServiceUnavailableException;
import org.com.meetingservice.messages.MeetingServiceMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@Slf4j
public class DoctorClientFallback implements DoctorClient {

    @Override
    public ResponseEntity<DoctorResponseDTO> getDoctorById(String id) {
        log.error("Doctor service unavailable - getDoctorById failed for id: {}", id);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getDoctors() {
        log.error("Doctor service unavailable - getDoctors failed");
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorsBySpecialization(Specialization specialization) {
        log.error("Doctor service unavailable - getDoctorsBySpecialization failed for specialization: {}", specialization);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorsByGender(Genders gender) {
        log.error("Doctor service unavailable - getDoctorsByGender failed");
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorId(String doctorId) {
        log.error("Doctor service unavailable - getSchedulesByDoctorId failed for doctor Id: {}", doctorId);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndDayOfTheWeek(String doctorId, CustomDayOfTheWeek dayOfTheWeek) {
        log.error("Doctor service unavailable - getSchedulesByDoctorIdAndDayOfTheWeek failed for doctor Id: {}, and day of the week: {}", doctorId,  dayOfTheWeek);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndScheduleDateBetween(String doctorId, LocalDate startDate, LocalDate endDate) {
        log.error("Doctor service unavailable - getSchedulesByDoctorIdAndScheduleDateBetween failed for doctorId: {}, start date: {}, end date: {}", doctorId, startDate, endDate);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndStartTimeAndEndTime(String doctorId, LocalTime startTime, LocalTime endTime) {
        log.error("Doctor service unavailable - getSchedulesByDoctorIdAndStartTimeAndEndTime failed for doctor Id: {}, start time: {}, end time: {}", doctorId, startTime, endTime);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<ScheduleResponseDTO> getSchedulesByDoctorIdDate(String doctorId, LocalDate date) {
        log.error("Doctor service unavailable -  getSchedulesByDoctorIdDate failed for doctor Id: {}, date: {}", doctorId, date);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }
}