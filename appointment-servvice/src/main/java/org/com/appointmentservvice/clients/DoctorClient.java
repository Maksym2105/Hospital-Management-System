package org.com.appointmentservvice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "doctor-service", fallback = DoctorClientFallback.class
)
public interface DoctorClient {


}
