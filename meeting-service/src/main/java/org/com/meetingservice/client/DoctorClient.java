package org.com.meetingservice.client;

import org.com.meetingservice.dto.DoctorResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "doctor-service", fallback = DoctorClientFallback.class
)
public interface DoctorClient {

    @GetMapping("/doc/{id}")
    ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable String id);

}
