package org.com.meetingservice.exception;

public class ScheduleNotAvailableException extends RuntimeException {
    public ScheduleNotAvailableException(String message) {
        super(message);
    }
}
