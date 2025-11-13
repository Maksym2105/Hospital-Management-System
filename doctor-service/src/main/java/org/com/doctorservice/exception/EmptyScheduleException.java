package org.com.doctorservice.exception;

public class EmptyScheduleException extends RuntimeException {
    public EmptyScheduleException(String message) {
        super(message);
    }
}
