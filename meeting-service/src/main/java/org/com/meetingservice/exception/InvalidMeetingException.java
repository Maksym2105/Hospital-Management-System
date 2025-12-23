package org.com.meetingservice.exception;

public class InvalidMeetingException extends RuntimeException {
    public InvalidMeetingException(String message) {
        super(message);
    }
}
