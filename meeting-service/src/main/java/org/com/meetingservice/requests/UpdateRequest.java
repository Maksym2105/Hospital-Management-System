package org.com.meetingservice.requests;

import lombok.Data;
import org.com.meetingservice.additional.MeetingStatus;

import java.time.Instant;

@Data
public class UpdateRequest {

    private Instant startTime;
    private Instant endTime;
    private MeetingStatus status;
}