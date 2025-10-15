package org.com.doctorservice.dto;

import java.util.UUID;

public record DoctorDeletedEvent(UUID doctorId) {
}
