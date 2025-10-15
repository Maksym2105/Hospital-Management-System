package org.com.patientservice.dto;

import java.util.UUID;

public record PatientDeletedEvent(UUID patientId) {
}
