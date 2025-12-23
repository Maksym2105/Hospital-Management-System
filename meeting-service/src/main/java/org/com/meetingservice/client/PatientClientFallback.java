package org.com.meetingservice.client;

import lombok.extern.slf4j.Slf4j;
import org.com.meetingservice.dto.PatientResponseDTO;
import org.com.meetingservice.exception.ServiceUnavailableException;
import org.com.meetingservice.messages.MeetingServiceMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PatientClientFallback implements PatientClient {


    @Override
    public PatientResponseDTO getPatientById(String id) {
        log.error("Patient service unavailable - getPatientById failed for id: {}", id);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }
}