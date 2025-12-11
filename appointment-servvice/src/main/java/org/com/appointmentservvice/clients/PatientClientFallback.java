package org.com.appointmentservvice.clients;

import lombok.extern.slf4j.Slf4j;
import org.com.appointmentservvice.dto.PatientResponseDTO;
import org.com.appointmentservvice.exception.ServiceUnavailableException;
import org.com.appointmentservvice.messaging.AppointmentServiceMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PatientClientFallback implements PatientClient {

    @Override
    public ResponseEntity<PatientResponseDTO> getPatientById(String id) {
        log.error("Patient service unavailable - getPatientById failed for id : {}", id);
        throw new ServiceUnavailableException(AppointmentServiceMessages.PATIENT_SERVICE_UNAVAILABLE.getMessage());
    }

    @Override
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        log.error("Patient service unavailable - getPatients failed");
        throw new ServiceUnavailableException(AppointmentServiceMessages.PATIENT_SERVICE_UNAVAILABLE.getMessage());
    }
}