package org.com.appointmentservvice.clients;

import org.com.appointmentservvice.dto.PatientResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "patient-service", fallback = PatientClientFallback.class
)
public interface PatientClient {

    @GetMapping("/api/{id}")
    ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable String id);

    @GetMapping("/api/patients")
    ResponseEntity<List<PatientResponseDTO>> getPatients();
}
