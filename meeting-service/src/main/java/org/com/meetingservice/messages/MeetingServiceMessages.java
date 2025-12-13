package org.com.meetingservice.messages;

public enum MeetingServiceMessages {

    SERVICE_UNAVAILABLE("Service unavailable");

    private final String message;

    MeetingServiceMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
