package org.com.meetingservice.repository;

import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.model.Meeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, UUID> {

    List<Meeting> findByPatientId(UUID patientId);
    List<Meeting> findDoctorId(UUID doctorId);
    List<Meeting> findByDoctorIdAndMeetingDate(UUID doctorId, LocalDate meetingDate);
    List<Meeting> findByPatientIdAndMeetingStatus(UUID patientId, MeetingStatus meetingStatus);
    List<Meeting> findByDoctorIdAndMeetingStatus(UUID doctorId, MeetingStatus meetingStatus);
    List<Meeting> findByMeetingStartTimeBetween(LocalTime startTime, LocalTime endTime);
    List<Meeting> findByMeetingDate(LocalDate meetingDate);
    boolean existsDoctorIdAndMeetingDateAndMeetingStartTimeAndMeetingStatus(
            UUID scheduleId, LocalDate meetingDate, LocalTime meetingStartTime, MeetingStatus meetingStatus);
}
