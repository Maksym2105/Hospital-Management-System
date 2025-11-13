package org.com.appointmentservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.com.appointmentservice.additional.AppointmentStatus;
import org.com.appointmentservice.dto.AppointmentRequestDTO;
import org.com.appointmentservice.dto.AppointmentResponseDTO;
import org.com.appointmentservice.dto.DoctorResponseDTO;
import org.com.appointmentservice.exception.DoctorNotFoundException;
import org.com.appointmentservice.exception.PatientNotFoundException;
import org.com.appointmentservice.mapper.AppointmentMapper;
import org.com.appointmentservice.messages.AppointmentServiceMessages;
import org.com.appointmentservice.model.Appointment;
import org.com.appointmentservice.model.DoctorEntity;
import org.com.appointmentservice.model.PatientEntity;
import org.com.appointmentservice.repository.AppointmentRepository;
import org.com.appointmentservice.repository.DoctorRepository;
import org.com.appointmentservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO request) {
        DoctorEntity doctor = doctorRepository.findById(UUID.fromString(request.getDoctorId()))
                .orElseThrow(() -> new DoctorNotFoundException(AppointmentServiceMessages.DOCTOR_NOT_FOUND.getMessage()));

        PatientEntity patient = patientRepository.findById(UUID.fromString(request.getPatientId()))
                .orElseThrow(() -> new PatientNotFoundException(AppointmentServiceMessages.PATIENT_NOT_FOUND.getMessage()));

        Appointment appointment = appointmentRepository.save(AppointmentMapper.toModel(request));

        AppointmentResponseDTO response = AppointmentResponseDTO.builder()
                .appointmentId(appointment.getAppointmentId().toString())

                .patientId(patient.getId().toString())
                .patientFirstName(patient.getFirstName())
                .patientLastName(patient.getLastName())
                .patientEmail(patient.getEmail())
                .patientPhoneNumber(patient.getPhoneNumber())

                .doctorId(doctor.getId().toString())
                .doctorFirstName(doctor.getFirstName())
                .doctorLastName(doctor.getLastName())
                .doctorEmail(doctor.getEmail())
                .doctorPhoneNumber(doctor.getPhoneNumber())
                .appointmentStatus(AppointmentStatus.CONFIRMED)
                .build();

        return response;
    }
}