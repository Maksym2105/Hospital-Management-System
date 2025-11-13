package org.com.appointmentservice.messages;

public enum AppointmentServiceMessages {

    DOCTOR_NOT_FOUND("Doctor not found!"),
    PATIENT_NOT_FOUND("Patient not found!");

    private final String message;

    private AppointmentServiceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return toString();
    }
}
