package org.com.doctorservice.exception;

public class EmptyModelException extends RuntimeException {
    public EmptyModelException(String message) {
        super(message);
    }
}
