package org.com.meetingservice.client;

import org.com.meetingservice.dto.PatientResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "patient-service", fallback = PatientClientFallback.class
)
public interface PatientClient {

    @GetMapping("/patient/{id}")
    PatientResponseDTO getPatientById(@PathVariable String id);
}
