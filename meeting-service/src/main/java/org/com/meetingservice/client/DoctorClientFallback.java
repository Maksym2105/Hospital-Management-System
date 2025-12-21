package org.com.meetingservice.client;

import lombok.extern.slf4j.Slf4j;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.exception.ServiceUnavailableException;
import org.com.meetingservice.messages.MeetingServiceMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DoctorClientFallback implements DoctorClient {

    @Override
    public ResponseEntity<DoctorResponseDTO> getDoctorById(String id) {
        log.error("Doctor service unavailable - getDoctorById failed for id: {}", id);
        throw new ServiceUnavailableException(MeetingServiceMessages.SERVICE_UNAVAILABLE.getMessage());
    }
}