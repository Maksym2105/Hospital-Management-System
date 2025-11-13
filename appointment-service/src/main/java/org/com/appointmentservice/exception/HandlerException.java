package org.com.appointmentservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Map<String, String>> doctorNotFoundException(DoctorNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        log.warn("Doctor not found: {}",  e.getMessage());

        errors.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> patientNotFoundException(PatientNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        log.warn("Patient not found: {}",  e.getMessage());

        errors.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NotValidMappingValueException.class)
    public ResponseEntity<Map<String, String>> notValidMappingValueException(NotValidMappingValueException e) {
        Map<String, String> errors = new HashMap<>();
        log.warn("Mapping value not valid: {}",  e.getMessage());

        errors.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}