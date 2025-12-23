package org.com.meetingservice.service;

import lombok.RequiredArgsConstructor;
import org.com.meetingservice.additional.MeetingStatus;
import org.com.meetingservice.client.DoctorClient;
import org.com.meetingservice.client.PatientClient;
import org.com.meetingservice.dto.BookingRequest;
import org.com.meetingservice.dto.DoctorResponseDTO;
import org.com.meetingservice.dto.MeetingResponse;
import org.com.meetingservice.dto.PatientResponseDTO;
import org.com.meetingservice.mapper.MeetingMapper;
import org.com.meetingservice.model.Meeting;
import org.com.meetingservice.repository.MeetingRepository;
import org.com.meetingservice.validation.DoctorValidation;
import org.com.meetingservice.validation.PatientValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final DoctorClient doctorClient;
    private final PatientClient patientClient;
    private final MeetingRepository meetingRepository;


    public MeetingResponse createMeeting(BookingRequest bookingRequest) {

        DoctorResponseDTO doctor = doctorClient.getDoctorById(bookingRequest.getDoctorId());
        PatientResponseDTO patient = patientClient.getPatientById(bookingRequest.getPatientId());

        DoctorValidation.checkDoctorStatus(doctor);

        DoctorValidation.checkDoctorSchedule(doctor, bookingRequest.getMeetingStartTime(), bookingRequest.getMeetingEndTime());

        DoctorValidation.checkDoctorAvailability(
                bookingRequest.getDoctorId(), bookingRequest.getMeetingStartTime(), bookingRequest.getMeetingEndTime());
        PatientValidation.checkPatientAvailability(
                bookingRequest.getPatientId(), bookingRequest.getMeetingStartTime(), bookingRequest.getMeetingEndTime()
        );

        Meeting meeting = MeetingMapper.toEntity(bookingRequest,  doctor, patient);
        Meeting saved  = meetingRepository.save(meeting);

        return  MeetingMapper.toResponse(saved);
    }

    public List<MeetingResponse> findByPatientId(UUID patientId) {
        return mapList(meetingRepository.findByPatientId(patientId));
    }

    public List<MeetingResponse> findByDoctorId(UUID doctorId) {
        return mapList(meetingRepository.findByDoctorId(doctorId));
    }

    public List<MeetingResponse> findByStatus(MeetingStatus meetingStatus) {
        return mapList(meetingRepository.findByStatus(meetingStatus));
    }

    private List<MeetingResponse> mapList(List<Meeting> meetings) {
        return meetings.stream()
                .map(MeetingMapper::toResponse)
                .toList();
    }


}