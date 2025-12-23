package org.com.meetingservice.validation;

import lombok.RequiredArgsConstructor;
import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.exception.MeetingConflictException;
import org.com.meetingservice.messages.MeetingServiceMessages;
import org.com.meetingservice.model.Meeting;
import org.com.meetingservice.repository.MeetingRepository;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
public class PatientValidation {

    private static MeetingRepository meetingRepository;

    public PatientValidation(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public static void checkPatientAvailability(String patientId, Instant start, Instant end) {
        List<Meeting> conflicts = meetingRepository.findByPatientIdAndStatusAndStartTimeBetween(
                UUID.fromString(patientId), MeetingStatus.CONFIRMED, start.minus(Duration.ofHours(4)), end.plus(Duration.ofHours(4))
        );

        boolean conflictsFound = conflicts.stream()
                .anyMatch(c -> timeOverlap(start, end, c.getStartTime(), c.getEndTime()));

        if (conflictsFound){
            throw new MeetingConflictException(MeetingServiceMessages.MEETING_CONFLICT.getMessage());
        }
    }

    private static boolean timeOverlap(Instant start1, Instant end1, Instant start2, Instant end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }
}