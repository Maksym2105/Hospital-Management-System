package org.com.patientservice.exception;

public class EmptyEntityException extends RuntimeException {
    public EmptyEntityException(String message) {
        super(message);
    }
}
