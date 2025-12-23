package org.com.meetingservice.exception;

public class MeetingConflictException extends RuntimeException {
    public MeetingConflictException(String message) {
        super(message);
    }
}
