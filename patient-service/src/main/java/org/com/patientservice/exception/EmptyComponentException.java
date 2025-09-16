package org.com.patientservice.exception;

public class EmptyComponentException extends RuntimeException {
    public EmptyComponentException(String message) {
        super(message);
    }
}
