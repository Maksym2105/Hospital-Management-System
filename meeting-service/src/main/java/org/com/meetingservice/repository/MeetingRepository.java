package org.com.meetingservice.repository;

import org.com.meetingservice.model.Meeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, UUID> {
}
