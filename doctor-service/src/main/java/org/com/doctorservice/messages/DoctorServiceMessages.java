package org.com.doctorservice.messages;

public enum DoctorServiceMessages {

    DOCTOR_IS_EMPTY("Doctor is empty!"),
    ARGUMENTS_NOT_VALID("Argument not valid!"),
    COMPONENT_IS_EMPTY("Component is empty!"),
    EMAIL_ALREADY_EXISTS("Email already exists!");

    private final String message;

    private DoctorServiceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
