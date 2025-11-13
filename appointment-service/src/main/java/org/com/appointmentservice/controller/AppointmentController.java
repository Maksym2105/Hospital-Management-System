package org.com.appointmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.com.appointmentservice.dto.AppointmentRequestDTO;
import org.com.appointmentservice.dto.AppointmentResponseDTO;
import org.com.appointmentservice.model.Appointment;
import org.com.appointmentservice.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO response = appointmentService.createAppointment(appointmentRequestDTO);
        return ResponseEntity.ok().body(response);
    }
}