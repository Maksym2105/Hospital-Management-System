package org.com.meetingservice.repository;

import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.model.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, String> {

    List<Meeting> findByPatientId(UUID patientId);
    List<Meeting> findByDoctorId(UUID doctorId);
    List<Meeting> findByStatus(MeetingStatus meetingStatus);
    List<Meeting> findByDoctorIdAndStatusAndStartTimeBetween(
            UUID doctorId, MeetingStatus meetingStatus, Instant meetingStartTime, Instant meetingEndTime);
    List<Meeting> findByPatientIdAndStatusAndStartTimeBetween(
            UUID patientId, MeetingStatus meetingStatus, Instant meetingStartTime, Instant meetingEndTime);
}
