package org.com.appointmentservvice.clients;

import lombok.extern.slf4j.Slf4j;
import org.com.appointmentservvice.additional.CustomDayOfTheWeek;
import org.com.appointmentservvice.dto.DoctorResponseDTO;
import org.com.appointmentservvice.dto.ScheduleResponseDTO;
import org.com.appointmentservvice.exception.ServiceUnavailableException;
import org.com.appointmentservvice.messaging.AppointmentServiceMessages;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
public class DoctorClientFallback implements DoctorClient {

    @Override
    public ResponseEntity<DoctorResponseDTO> getDoctorById(String id) {
        log.error("Doctor service unavailable - getDoctorById failed for id: {}", id);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        log.error("Doctor service unavailable - getAllDoctors failed");
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorsBySpecialization(String specialization) {
        log.error("Doctor service unavailable - getDoctorsBySpecialization failed for specialization: {}", specialization);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorsByGender(String gender) {
        log.error("Doctor service unavailable - getDoctorsByGender failed  for gender: {}", gender);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorId(String doctorId) {
        log.error("Doctor service unavailable - getSchedulesByDoctorId failed for doctorId: {}", doctorId);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndDayOfTheWeek(String doctorId, CustomDayOfTheWeek customDayOfTheWeek) {
        log.error("Doctor service unavailable - getSchedulesByDoctorIdAndDayOfTheWeek failed for doctorId: {}, customDayOfTheWeek: {}", doctorId, customDayOfTheWeek);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndDate(String doctorId, LocalDate startDate, LocalDate endDate) {
        log.error("Doctor service unavailable - getSchedulesByDoctorIdAndDate failed for doctorId: {}, startDate: {}", doctorId, startDate);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<ScheduleResponseDTO>> getSchedulesByDoctorIdAndTimeBetween(String id, LocalTime startTime, LocalTime endTime) {
        log.error("Doctor service unavailable - getSchedulesByDoctorIdAndTime failed for doctorId: {}, startTime: {}, endTime: {}", id, startTime, endTime);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<ScheduleResponseDTO> getScheduleByDoctorIdAndDate(String id, LocalDate date) {
        log.error("Doctor service unavailable - getScheduleByDoctorIdAndDate failed for doctorId: {}, date: {}", id, date);
        throw new ServiceUnavailableException(AppointmentServiceMessages.DOCTOR_SERVICE_UNAVAILABLE.getMessage());
    }
}