package org.com.meetingservice.repository;

import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.model.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, UUID> {

    Page<Meeting> findByPatientId(UUID patientId);
    Page<Meeting> findDoctorId(UUID doctorId);
    Page<Meeting> findByMeetingStatus(MeetingStatus meetingStatus);
    List<Meeting> findByDoctorIdAndMeetingStatusAndMeetingStartTimeBetween(
            UUID doctorId,MeetingStatus meetingStatus, LocalTime meetingStartTime, LocalTime meetingEndTime);
    List<Meeting> findByPatientIdAndMeetingStatusAndMeetingStartTimeBetween(
            UUID patientId, MeetingStatus meetingStatus, LocalTime meetingStartTime, LocalTime meetingEndTime);
}
