package org.com.patientservice.messages;

public enum PatientMessages {

    REQUEST_EMPTY("Request is empty"),
    MODEL_EMPTY("Model is empty"),
    RESPONSE_EMPTY("Response is empty"),
    EMAIL_ALREADY_EXISTS("Email already exists"),
    PATIENT_NOT_FOUND("Patient not found"),
    API_FOR_MANAGING_PATIENTS("API for managing patients");

    private final String message;

    private PatientMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
