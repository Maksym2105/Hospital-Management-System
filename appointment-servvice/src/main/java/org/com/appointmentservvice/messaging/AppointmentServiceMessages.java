package org.com.appointmentservvice.messaging;

import lombok.Getter;

public enum AppointmentServiceMessages {

    TEST("TEST"),
    DOCTOR_SERVICE_UNAVAILABLE("Doctor service currently is not available");

    private final String message;

    AppointmentServiceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
