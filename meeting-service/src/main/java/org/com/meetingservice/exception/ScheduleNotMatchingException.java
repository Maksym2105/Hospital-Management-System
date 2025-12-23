package org.com.meetingservice.exception;

public class ScheduleNotMatchingException extends RuntimeException {
    public ScheduleNotMatchingException(String message) {
        super(message);
    }
}
